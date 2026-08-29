package com.lifeos.feature.dashboard

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

import com.lifeos.designsystem.LifeOSTheme
import com.lifeos.ui.components.LifeOSCard

/**
 * Real header, real card component, honest empty state. Goal/habit/finance
 * summaries will replace this section-by-section once their domain models
 * and repositories exist (Phase 3/4) — wiring fake numbers in now would
 * just get discarded later.
 */
@Composable
fun DashboardScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(LifeOSTheme.spacing.lg),
        verticalArrangement = Arrangement.spacedBy(LifeOSTheme.spacing.lg),
    ) {
        Text(text = "Today", style = MaterialTheme.typography.displayMedium)
        Text(
            text = "Your life, in one place.",
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
        )

        LifeOSCard(modifier = Modifier.fillMaxWidth()) {
            Text(text = "Nothing tracked yet", style = MaterialTheme.typography.titleMedium)
            Text(
                text = "Once you add goals and habits, your progress shows up here.",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
            )
        }
    }
}