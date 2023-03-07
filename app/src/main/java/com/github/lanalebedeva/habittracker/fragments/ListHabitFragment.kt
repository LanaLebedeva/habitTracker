package com.github.lanalebedeva.habittracker.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.github.lanalebedeva.habittracker.R
import com.github.lanalebedeva.habittracker.adapter.HabitsAdapter
import com.github.lanalebedeva.habittracker.databinding.FragmentListHabitBinding
import com.github.lanalebedeva.habittracker.viewmodel.HabitsViewModel

class ListHabitFragment : Fragment() {
    private val viewModel: HabitsViewModel by activityViewModels()

    private  var _binding: FragmentListHabitBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentListHabitBinding.inflate(inflater)


        val adapter = HabitsAdapter(viewModel.habits.value) {
            Log.d("Position", "Position =$it")
        }

        val recycle = binding.fragmentListHabitRecycleView
        recycle.adapter = adapter

        binding.fragmentListHabitFab.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.activity_main_fragmentContainerView, HabitFragment())
                .addToBackStack("First task")
                .commit()
            adapter.notifyDataSetChanged()
        }
        return binding.root
    }



    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
