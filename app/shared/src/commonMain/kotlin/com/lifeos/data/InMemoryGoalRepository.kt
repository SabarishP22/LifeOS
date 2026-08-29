package com.lifeos.data

import com.lifeos.domain.model.Goal
import com.lifeos.domain.repository.GoalRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlin.uuid.Uuid

/**
 * Temporary: holds state in memory only, lost on process death. This
 * exists so the UI layer has something real to observe before Phase 7's
 * persistence layer lands — it satisfies the same GoalRepository contract
 * a database-backed implementation will, so replacing it later is a
 * one-line swap wherever it's provided, not a UI rewrite.
 */
class InMemoryGoalRepository : GoalRepository {

    private val goals = MutableStateFlow<List<Goal>>(emptyList())

    override fun observeGoals(): Flow<List<Goal>> = goals.asStateFlow()

    override suspend fun addGoal(title: String, description: String) {
        val goal = Goal(id = Uuid.random().toString(), title = title, description = description)
        goals.update { it + goal }
    }

    override suspend fun updateProgress(goalId: String, progress: Float) {
        goals.update { list ->
            list.map { if (it.id == goalId) it.copy(progress = progress.coerceIn(0f, 1f)) else it }
        }
    }

    override suspend fun deleteGoal(goalId: String) {
        goals.update { list -> list.filterNot { it.id == goalId } }
    }
}