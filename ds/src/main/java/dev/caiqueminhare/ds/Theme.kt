package dev.caiqueminhare.ds

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.Colors
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorPalette = darkColors(
    primary = LightNavy,
    primaryVariant = GovernorBay,
    secondary = Tundora,
    secondaryVariant = MineShaft
)

private val LightColorPalette = lightColors(
    primary = LightNavy,
    primaryVariant = GovernorBay,
    secondary = Tundora,
    secondaryVariant = MineShaft,
    surface = Color.White
)

@Composable
fun ComposePlaygroundTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}