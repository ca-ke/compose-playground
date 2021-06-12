package dev.caiqueminhare.home.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.shape.ZeroCornerSize
import androidx.compose.material.Button
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.constraintlayout.widget.ConstraintSet
import dev.caiqueminhare.ds.LightNavy

@Composable
fun HomeScreen() {
    Box {
        Row(
            modifier = Modifier
                .background(Color(0xffd55359), shape = RoundedCornerShape(20.dp))
                .size(width = 360.dp, height = 120.dp)
                .padding(horizontal = 24.dp)
                .align(Alignment.Center)
                .zIndex(1f),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Text(text =  "Fatura fechada")
                Text(text =  "R$ 1.445,00")
            }
            Column {
                Button(onClick = { /*TODO*/ }) {
                    Text("Pagar")
                }
                Text(text =  "Vencimento 10 Fev")
            }
        }
        Column(modifier = Modifier.background(Color.White)) {
            Row(
                modifier = Modifier
                    .weight(1f)
                    .background(Color(0xff3e2042), shape = CustomShape())
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Row(
                    modifier = Modifier
                        .background(Color(0xff673171), shape = RoundedCornerShape(20.dp))
                        .size(width = 360.dp, height = 240.dp)
                        .padding(horizontal = 24.dp)
                ) {

                }
            }
            Row(
                modifier = Modifier
                    .weight(0.9f)
                    .background(Color.White)
                    .fillMaxWidth()
            ) {
                LazyColumn(
                    Modifier.padding(top = 64.dp)
                ) {
                    items(100) {
                        Text("Ola")
                    }
                }
            }
        }
    }
}

class CustomShape : Shape {
    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    ): Outline {
        val path = Path().apply {
            lineTo(0f, size.height - 80)

            val firstPoint = Offset(size.width/2, size.height + 80)
            val firstEndPoint = Offset(size.width, size.height - 80)
            quadraticBezierTo(firstPoint.x, firstPoint.y, firstEndPoint.x, firstEndPoint.y)

            lineTo(size.width, 0f)
            close()
        }
        return Outline.Generic(path)
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}