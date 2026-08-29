package com.lifeos.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.lifeos.feature.dashboard.DashboardScreen
import com.lifeos.feature.goals.GoalsScreen

/**
 * Root app shell: owns which top-level destination is selected and renders
 * the primary navigation surface plus the current screen's content.
 *
 * Deliberately state-based rather than backed by a navigation library —
 * there's no nested back stack yet. Revisit once a Phase 3 screen (e.g.
 * goal detail) needs one.
 */
@Composable
fun AppShell() {
    var selected by remember { mutableStateOf(AppDestination.Dashboard) }

    Scaffold(
        bottomBar = {
            NavigationBar {
                AppDestination.entries.forEach { destination ->
                    NavigationBarItem(
                        selected = destination == selected,
                        onClick = { selected = destination },
                        icon = { Text(destination.iconGlyph) },
                        label = { Text(destination.label) },
                    )
                }
            }
        },
    ) { innerPadding ->
        val contentModifier = Modifier.padding(innerPadding).fillMaxSize()
        when (selected) {
            AppDestination.Dashboard -> DashboardScreen(contentModifier)
            AppDestination.Goals -> GoalsScreen(contentModifier)
            AppDestination.Habits -> PlaceholderScreen(contentModifier, "Habits")
            AppDestination.Finance -> PlaceholderScreen(contentModifier, "Finance")
            AppDestination.Insights -> PlaceholderScreen(contentModifier, "Insights")
        }
    }
}

@Composable
private fun PlaceholderScreen(modifier: Modifier, title: String) {
    Box(modifier = modifier, contentAlignment = Alignment.Center) {
        Text(text = title, style = MaterialTheme.typography.headlineMedium)
    }
}