package com.lifeos.designsystem

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/** 4dp-based spacing scale. Reach for these instead of ad-hoc dp values everywhere. */
data class LifeOSSpacing(
    val xs: Dp = 4.dp,
    val sm: Dp = 8.dp,
    val md: Dp = 12.dp,
    val lg: Dp = 16.dp,
    val xl: Dp = 24.dp,
    val xxl: Dp = 32.dp,
    val xxxl: Dp = 48.dp,
)

internal val LocalLifeOSSpacing = staticCompositionLocalOf { LifeOSSpacing() }