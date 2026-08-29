package com.lifeos.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip

import com.lifeos.designsystem.LifeOSTheme

/**
 * The base surface for grouped content across LifeOS — dashboard sections,
 * goal summaries, habit rows. Wraps LifeOSTheme's card surface color and
 * shape so every card in the app is visually consistent by construction,
 * not by convention screens have to remember to follow.
 */
@Composable
fun LifeOSCard(
    modifier: Modifier = Modifier,
    content: @Composable ColumnScope.() -> Unit,
) {
    Column(
        modifier = modifier
            .clip(MaterialTheme.shapes.medium)
            .background(LifeOSTheme.colors.cardSurface)
            .padding(LifeOSTheme.spacing.lg),
        content = content,
    )
}