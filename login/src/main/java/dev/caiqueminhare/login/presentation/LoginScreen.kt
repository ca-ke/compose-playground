package dev.caiqueminhare.login.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.shape.ZeroCornerSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.caiqueminhare.ds.ComposePlaygroundTheme

@Composable
fun LoginScreen(loginViewModel: LoginViewModel) {
    Box {
        Surface(
            color = ComposePlaygroundTheme.colors.primary,
            modifier = Modifier.fillMaxSize()
        ) {

        }
        Surface(
            color = ComposePlaygroundTheme.colors.primary,
            modifier = Modifier
                .height(600.dp)
                .fillMaxWidth()
                .align(Alignment.BottomStart),
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
                val typedUser = remember { mutableStateOf("Usuário") }
                val typedPassword = remember { mutableStateOf("Senha") }

                OutlinedTextField(
                    value = typedUser.value,
                    onValueChange = { textFieldValue ->
                        typedUser.value = textFieldValue
                        loginViewModel.onTextChanged(
                            typedText = textFieldValue,
                            textFieldType = "password"
                        )
                    },
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
                    value = typedPassword.value,
                    onValueChange = { textFieldValue ->
                        typedPassword.value = textFieldValue
                        loginViewModel.onTextChanged(
                            typedText = textFieldValue,
                            textFieldType = "password"
                        )
                    },
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
                        .padding(end = 16.dp)
                )

                Button(
                    onClick = loginViewModel::doLogin,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 16.dp, end = 16.dp, top = 64.dp),
                    contentPadding = PaddingValues(16.dp),
                ) {
                    Text(text = "Entrar")
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