package com.github.lanalebedeva.habittracker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.github.lanalebedeva.habittracker.databinding.ActivityMainBinding
import com.github.lanalebedeva.habittracker.fragments.ListHabitFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var listHabitFragment: ListHabitFragment
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            listHabitFragment = ListHabitFragment()
            supportFragmentManager.beginTransaction()
                .replace(
                    R.id.activity_main_fragmentContainerView,
                    listHabitFragment,
                    "listHabitFragment"
                )
                .addToBackStack(null)
                .commit()
        } else {
            listHabitFragment =
                supportFragmentManager.findFragmentByTag("listHabitFragment") as ListHabitFragment
        }
    }
}
