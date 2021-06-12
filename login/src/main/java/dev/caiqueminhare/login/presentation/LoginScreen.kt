package dev.caiqueminhare.login.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.shape.ZeroCornerSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.caiqueminhare.login.domain.model.ButtonState

@Composable
fun LoginScreen(loginViewModel: LoginViewModel) {
    Box(
        contentAlignment = Alignment.BottomCenter
    ) {
        Surface(
            color = MaterialTheme.colors.primary,
            modifier = Modifier.fillMaxSize()
        ) {

        }
        Column {
            Surface(
                color = MaterialTheme.colors.surface,
                modifier = Modifier
                    .height(400.dp)
                    .fillMaxWidth(),
                shape = RoundedCornerShape(60.dp)
                    .copy(
                        bottomStart = ZeroCornerSize,
                        bottomEnd = ZeroCornerSize
                    )
            ) {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    val typedUser: String by loginViewModel.userFieldState.observeAsState("")
                    val typedUserError: Boolean by loginViewModel.userFieldErrorState.observeAsState(
                        false
                    )
                    val typedPassword: String by loginViewModel.passwordFieldState.observeAsState("")
                    val typedPasswordError: Boolean by loginViewModel.passwordFieldErrorState.observeAsState(
                        false
                    )

                    OutlinedTextField(
                        value = typedUser,
                        onValueChange = { textFieldValue ->
                            loginViewModel.onTextChanged(
                                typedText = textFieldValue,
                                textFieldType = "user"
                            )
                        },
                        isError = typedUserError,
                        singleLine = true,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp, vertical = 8.dp),
                        label = { Text(text = "Usuário") },
                        leadingIcon = { Icon(Icons.Filled.Email, "usuário") },
                        colors = TextFieldDefaults.textFieldColors(
                            textColor = Color.Gray,
                        )
                    )
                    OutlinedTextField(
                        value = typedPassword,
                        onValueChange = { textFieldValue ->
                            loginViewModel.onTextChanged(
                                typedText = textFieldValue,
                                textFieldType = "password"
                            )
                        },
                        isError = typedPasswordError,
                        singleLine = true,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp),
                        label = { Text(text = "Senha") },
                        visualTransformation = PasswordVisualTransformation(),
                        leadingIcon = { Icon(Icons.Filled.Lock, "senha") },
                        colors = TextFieldDefaults.textFieldColors(
                            textColor = Color.Gray,
                        )
                    )
                    Text(
                        text = "Esqueceu a sua senha?",
                        color = Color.Blue,
                        modifier = Modifier
                            .align(Alignment.End)
                            .padding(top = 4.dp, end = 16.dp)
                    )

                    Button(
                        onClick = loginViewModel::doLogin,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 16.dp, end = 16.dp, top = 64.dp),
                        contentPadding = PaddingValues(16.dp),
                    ) {
                        val buttonState: ButtonState by loginViewModel.buttonState.observeAsState(
                            ButtonState.Enabled
                        )

                        when (buttonState) {
                            is ButtonState.Enabled -> Text(text = "Entrar")

                            else -> {
                                CircularProgressIndicator(
                                    color = Color.White,
                                    modifier = Modifier.size(24.dp)
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun LoginScreenPreview() {
    LoginScreen(LoginViewModel())
}