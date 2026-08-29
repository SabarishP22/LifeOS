package com.lifeos.feature.goals

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lifeos.domain.repository.GoalRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class GoalsViewModel(
    private val goalRepository: GoalRepository,
) : ViewModel() {

    val uiState: StateFlow<GoalsUiState> = goalRepository.observeGoals()
        .map { GoalsUiState(goals = it) }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = GoalsUiState(),
        )

    fun addGoal(title: String) {
        if (title.isBlank()) return
        viewModelScope.launch {
            goalRepository.addGoal(title = title.trim())
        }
    }
}