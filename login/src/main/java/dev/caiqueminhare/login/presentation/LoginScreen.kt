package dev.caiqueminhare.login.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.shape.ZeroCornerSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.caiqueminhare.ds.Purple200

@Composable
fun LoginScreen() {
    Box {
        Surface(
            color = Purple200,
            modifier = Modifier.fillMaxSize()
        ) {

        }
        Surface(
            color = Color.White,
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

        }
    }
}

@Preview
@Composable
fun LoginScreenPreview() {
    LoginScreen()
}