package com.lifeos.feature.goals

import com.lifeos.domain.model.Goal

data class GoalsUiState(
    val goals: List<Goal> = emptyList(),
)