package com.github.lanalebedeva.habittracker.data


enum class Priority {
    HIGHT,
    MEDIUM,
    LOW,
}

enum class Type {
    GOOD,
    BAD
}
data class Habit(
    val UID: String,
    val name: String,
    val description: String,
    val count: Int,
    val date: Int,
    val priority: Priority,
    val type: Type,
    val color: Int,
)

