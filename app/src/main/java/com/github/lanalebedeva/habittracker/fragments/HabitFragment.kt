package com.github.lanalebedeva.habittracker.fragments

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.activityViewModels
import com.github.lanalebedeva.habittracker.data.Habit
import com.github.lanalebedeva.habittracker.data.Priority
import com.github.lanalebedeva.habittracker.data.Type
import com.github.lanalebedeva.habittracker.databinding.FragmentHabitBinding
import com.github.lanalebedeva.habittracker.viewmodel.HabitsViewModel
import java.time.Instant


class HabitFragment : Fragment() {
    private val viewModel: HabitsViewModel by activityViewModels()

    private var _binding: FragmentHabitBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHabitBinding.inflate(inflater)
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.fragmentHabitButtonSave.setOnClickListener {
            viewModel.addHabit(
                Habit(
                    UID = Instant.now().toString(),
                    name = "Homework",
                    description = "well do it",
                    count = 5,
                    date = 5,
                    color = Color.BLUE,
                    priority = Priority.LOW,
                    type = Type.GOOD,
                )
            )
            Log.d("FRRR+", "viewModel = ${viewModel.habits.value.toString()}")
//            parentFragmentManager.beginTransaction().hide(this).commit()
        }

    }
}
