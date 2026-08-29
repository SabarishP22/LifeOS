package com.lifeos.designsystem

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Shapes
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.dp

internal val LifeOSShapes = Shapes(
    extraSmall = RoundedCornerShape(6.dp),
    small = RoundedCornerShape(10.dp),
    medium = RoundedCornerShape(14.dp),
    large = RoundedCornerShape(20.dp),
    extraLarge = RoundedCornerShape(28.dp),
)

/** Shapes Material3 doesn't model — e.g. pill-shaped streak/status chips. */
data class LifeOSExtraShapes(
    val pill: RoundedCornerShape = RoundedCornerShape(percent = 50),
)

internal val LocalLifeOSExtraShapes = staticCompositionLocalOf { LifeOSExtraShapes() }