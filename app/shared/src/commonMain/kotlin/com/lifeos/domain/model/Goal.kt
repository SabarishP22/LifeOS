package com.lifeos.domain.model

/**
 * Deliberately minimal for now — no due date, no linked habits/tasks yet.
 * Those relationships (a goal having tasks, being tied to habits — spec §3)
 * get added once Tasks and Habits exist as their own models; adding fields
 * speculatively now would just be guessing at a shape we don't know yet.
 */
data class Goal(
    val id: String,
    val title: String,
    val description: String = "",
    val progress: Float = 0f,
)