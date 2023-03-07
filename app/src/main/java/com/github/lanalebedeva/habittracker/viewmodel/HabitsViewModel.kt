package com.github.lanalebedeva.habittracker.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.github.lanalebedeva.habittracker.data.Habit

class HabitsViewModel: ViewModel() {
    private var _habits = MutableLiveData<List<Habit>>()
    val habits: LiveData<List<Habit>> = _habits

    init {
        getHabits()
    }

    fun getHabitByPos(pos: Int): Habit {
        return habits.value!![pos]
    }

    fun addHabit(habit: Habit) {
        _habits.value = _habits.value?.plus(habit) ?: mutableListOf(habit)
    }
    private fun getHabits() {
        _habits.value = listOf<Habit>()
    }
}
