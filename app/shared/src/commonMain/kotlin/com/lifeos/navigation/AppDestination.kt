package com.lifeos.navigation

/**
 * Top-level destinations shown in the primary navigation surface (bottom
 * bar on phone; will adapt to a NavigationRail on larger surfaces in a
 * later milestone).
 *
 * `iconGlyph` is a deliberate placeholder, not a shortcut: LifeOS's visual
 * identity calls for a custom icon set (spec §11), not generic Material
 * icons, so real iconography is a design decision to make once, not a
 * dependency to bolt on now.
 */
enum class AppDestination(
    val label: String,
    val iconGlyph: String,
) {
    Dashboard(label = "Today", iconGlyph = "◆"),
    Goals(label = "Goals", iconGlyph = "▲"),
    Habits(label = "Habits", iconGlyph = "●"),
    Finance(label = "Finance", iconGlyph = "■"),
    Insights(label = "Insights", iconGlyph = "◈"),
}