package com.lifeos.domain.repository

import com.lifeos.domain.model.Goal
import kotlinx.coroutines.flow.Flow

/**
 * Contract only — no implementation detail leaks through this interface.
 * The ViewModel layer depends on this, never on InMemoryGoalRepository
 * directly, so swapping in a database-backed implementation in Phase 7
 * touches this file's implementers, not its callers.
 */
interface GoalRepository {
    fun observeGoals(): Flow<List<Goal>>
    suspend fun addGoal(title: String, description: String = "")
    suspend fun updateProgress(goalId: String, progress: Float)
    suspend fun deleteGoal(goalId: String)
}