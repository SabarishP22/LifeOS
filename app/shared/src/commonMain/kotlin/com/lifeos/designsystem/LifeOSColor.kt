package com.lifeos.designsystem

import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color

/**
 * Raw LifeOS brand palette. Never reference these directly from screens —
 * always go through LifeOSTheme. colors so light/dark stay consistent.
 */
internal object LifeOSPalette {
    val Ink = Color(0xFF14161F)
    val InkMuted = Color(0xFF3A3D4D)
    val Paper = Color(0xFFF6F5F1)
    val Surface = Color(0xFFFFFFFF)
    val SurfaceDark = Color(0xFF1C1F2B)
    val Signal = Color(0xFF3454D1)
    val SignalMuted = Color(0xFFDDE3FA)
    val Ember = Color(0xFFE8A33D)
    val Sage = Color(0xFF4C9A79)
    val Danger = Color(0xFFD65252)
    val Outline = Color(0xFFDEDCD4)
    val OutlineDark = Color(0xFF33364A)
}

/** Semantic colors Material3's ColorScheme doesn't model: streaks, growth trend, card surfaces. */
data class LifeOSExtendedColors(
    val energy: Color,
    val energyContainer: Color,
    val growth: Color,
    val growthContainer: Color,
    val cardSurface: Color,
)

internal val LightExtendedColors = LifeOSExtendedColors(
    energy = LifeOSPalette.Ember,
    energyContainer = Color(0xFFFBEBD2),
    growth = LifeOSPalette.Sage,
    growthContainer = Color(0xFFDCEEE5),
    cardSurface = LifeOSPalette.Surface,
)

internal val DarkExtendedColors = LifeOSExtendedColors(
    energy = LifeOSPalette.Ember,
    energyContainer = Color(0xFF4A3A1C),
    growth = LifeOSPalette.Sage,
    growthContainer = Color(0xFF203830),
    cardSurface = LifeOSPalette.SurfaceDark,
)

internal val LifeOSLightColorScheme = lightColorScheme(
    primary = LifeOSPalette.Signal,
    onPrimary = Color.White,
    primaryContainer = LifeOSPalette.SignalMuted,
    onPrimaryContainer = LifeOSPalette.Ink,
    secondary = LifeOSPalette.Sage,
    onSecondary = Color.White,
    error = LifeOSPalette.Danger,
    onError = Color.White,
    background = LifeOSPalette.Paper,
    onBackground = LifeOSPalette.Ink,
    surface = LifeOSPalette.Surface,
    onSurface = LifeOSPalette.Ink,
    surfaceVariant = Color(0xFFEDEBE3),
    onSurfaceVariant = LifeOSPalette.InkMuted,
    outline = LifeOSPalette.Outline,
)

internal val LifeOSDarkColorScheme = darkColorScheme(
    primary = LifeOSPalette.Signal,
    onPrimary = Color.White,
    primaryContainer = Color(0xFF25326E),
    onPrimaryContainer = Color(0xFFDDE3FA),
    secondary = LifeOSPalette.Sage,
    onSecondary = Color.White,
    error = LifeOSPalette.Danger,
    onError = Color.White,
    background = LifeOSPalette.Ink,
    onBackground = Color(0xFFEDECE8),
    surface = LifeOSPalette.SurfaceDark,
    onSurface = Color(0xFFEDECE8),
    surfaceVariant = Color(0xFF262A3A),
    onSurfaceVariant = Color(0xFFC5C7D6),
    outline = LifeOSPalette.OutlineDark,
)