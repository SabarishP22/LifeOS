package com.lifeos.designsystem

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf

private val LocalLifeOSExtendedColors = staticCompositionLocalOf { LightExtendedColors }

/**
 * LifeOS design system entry point. Mirrors Material3's own MaterialTheme
 * pattern (an object with an `invoke` operator): wrap content with
 * `LifeOSTheme { ... }`, then read tokens below it via
 * `LifeOSTheme.colors`, `LifeOSTheme.spacing`, `LifeOSTheme.extraShapes`.
 * Screens should never reach for MaterialTheme or raw hex colors directly.
 */
object LifeOSTheme {

    val colors: LifeOSExtendedColors
        @Composable @ReadOnlyComposable get() = LocalLifeOSExtendedColors.current

    val spacing: LifeOSSpacing
        @Composable @ReadOnlyComposable get() = LocalLifeOSSpacing.current

    val extraShapes: LifeOSExtraShapes
        @Composable @ReadOnlyComposable get() = LocalLifeOSExtraShapes.current

    val metricTextStyle
        @Composable @ReadOnlyComposable get() = LocalLifeOSMetricTextStyle.current

    @Composable
    operator fun invoke(
        darkTheme: Boolean = isSystemInDarkTheme(),
        content: @Composable () -> Unit,
    ) {
        val extendedColors = if (darkTheme) DarkExtendedColors else LightExtendedColors
        val colorScheme = if (darkTheme) LifeOSDarkColorScheme else LifeOSLightColorScheme

        CompositionLocalProvider(
            LocalLifeOSExtendedColors provides extendedColors,
            LocalLifeOSSpacing provides LifeOSSpacing(),
            LocalLifeOSExtraShapes provides LifeOSExtraShapes(),
            LocalLifeOSMetricTextStyle provides LifeOSMetricTextStyle,
        ) {
            MaterialTheme(
                colorScheme = colorScheme,
                typography = LifeOSTypography,
                shapes = LifeOSShapes,
                content = content,
            )
        }
    }
}