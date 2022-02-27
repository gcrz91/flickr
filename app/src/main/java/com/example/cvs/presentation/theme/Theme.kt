package com.example.cvs.presentation.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

private val DarkColorPalette = darkColors(
    primary = Purple200,
    primaryVariant = Purple700,
    secondary = Teal200
)

private val LightColorPalette = lightColors(
    primary = Purple500,
    primaryVariant = Purple700,
    secondary = Teal200
)

private val LocalAppDimensions = staticCompositionLocalOf {
    smallDimensions
}

@Composable
fun ProvideDimens(
    dimensions: Dimensions,
    content: @Composable () -> Unit
) {
    val dimensionSet = remember { dimensions }
    CompositionLocalProvider(LocalAppDimensions provides dimensionSet, content = content)
}

@Composable
fun CvsTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {

    val smallScreen = LocalConfiguration.current.screenWidthDp <= 360
    val dimensions = if (smallScreen) smallDimensions else defaultDimensions

    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    ProvideDimens(dimensions = dimensions) {
        MaterialTheme(
            colors = colors,
            typography = Typography,
            shapes = Shapes,
            content = content
        )
    }
}

object CvsTheme {
    val dimens: Dimensions
        @Composable
        get() = LocalAppDimensions.current
}

data class Dimensions(
    val detailsImageHeight: Dp,
    val listImageHeight: Dp,
    val listItemPadding: Dp
)

val smallDimensions = Dimensions(
    detailsImageHeight = 256.dp,
    listImageHeight = 100.dp,
    listItemPadding = 4.dp
)

val defaultDimensions = Dimensions(
    detailsImageHeight = 500.dp,
    listImageHeight = 156.dp,
    listItemPadding = 8.dp
)