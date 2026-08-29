package com.lifeos.di

import com.lifeos.data.InMemoryGoalRepository
import com.lifeos.domain.repository.GoalRepository

/**
 * Manual composition root — deliberately not a DI framework. With one
 * dependency to provide, Koin/Hilt would be pure ceremony. Revisit once
 * manual wiring gets repetitive across several repositories.
 */
object AppGraph {
    val goalRepository: GoalRepository by lazy { InMemoryGoalRepository() }
}