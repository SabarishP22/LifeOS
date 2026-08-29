package com.lifeos.feature.goals

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory

import com.lifeos.designsystem.LifeOSTheme
import com.lifeos.di.AppGraph
import com.lifeos.domain.model.Goal
import com.lifeos.ui.components.LifeOSCard

@Composable
fun GoalsScreen(modifier: Modifier = Modifier) {
    val viewModel: GoalsViewModel = viewModel(
        factory = viewModelFactory {
            initializer { GoalsViewModel(AppGraph.goalRepository) }
        },
    )
    val uiState by viewModel.uiState.collectAsState()
    var newGoalTitle by remember { mutableStateOf("") }

    Column(
        modifier = modifier.fillMaxWidth().padding(LifeOSTheme.spacing.lg),
        verticalArrangement = Arrangement.spacedBy(LifeOSTheme.spacing.lg),
    ) {
        Text(text = "Goals", style = MaterialTheme.typography.displayMedium)

        Row(horizontalArrangement = Arrangement.spacedBy(LifeOSTheme.spacing.sm)) {
            OutlinedTextField(
                value = newGoalTitle,
                onValueChange = { newGoalTitle = it },
                modifier = Modifier.weight(1f),
                label = { Text("New goal") },
                singleLine = true,
            )
            Button(onClick = {
                viewModel.addGoal(newGoalTitle)
                newGoalTitle = ""
            }) {
                Text("Add")
            }
        }

        if (uiState.goals.isEmpty()) {
            LifeOSCard(modifier = Modifier.fillMaxWidth()) {
                Text(text = "No goals yet", style = MaterialTheme.typography.titleMedium)
                Text(
                    text = "Add your first goal above to start tracking progress.",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                )
            }
        } else {
            LazyColumn(verticalArrangement = Arrangement.spacedBy(LifeOSTheme.spacing.md)) {
                items(uiState.goals, key = { it.id }) { goal -> GoalRow(goal) }
            }
        }
    }
}

@Composable
private fun GoalRow(goal: Goal) {
    LifeOSCard(modifier = Modifier.fillMaxWidth()) {
        Text(text = goal.title, style = MaterialTheme.typography.titleMedium)
        if (goal.description.isNotBlank()) {
            Text(
                text = goal.description,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
            )
        }
    }
}