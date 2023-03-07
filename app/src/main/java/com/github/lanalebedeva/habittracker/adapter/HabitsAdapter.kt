package com.github.lanalebedeva.habittracker.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.github.lanalebedeva.habittracker.R
import com.github.lanalebedeva.habittracker.data.Habit

class HabitsAdapter(
    private val listHabit: List<Habit>?,
    private val action: (uid: Int) -> Unit
) : RecyclerView.Adapter<HabitViewHolder>() {

    private val items: List<Habit> = listHabit ?: listOf()
//        Habit(
//            UID = "1",
//            name = "Homework",
//            description = "well do it",
//            count = 5,
//            date = 5,
//            color = Color.BLUE,
//            priority = Priority.LOW,
//            type = Type.GOOD,
//        ),
//        Habit(
//            UID = "2",
//            name = "Relax",
//            description = "well do it",
//            count = 5,
//            date = 1,
//            color = Color.RED,
//            priority = Priority.LOW,
//            type = Type.GOOD,
//        )
//    )



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HabitViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_habit, parent, false)
        return HabitViewHolder(view)
    }

    override fun onBindViewHolder(holder: HabitViewHolder, position: Int) {
        val content = items[holder.adapterPosition]
        holder.populate(content)
        holder.itemView.setOnClickListener {
            action(holder.adapterPosition)
//            action(items[holder.adapterPosition].UID)
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }
}

class HabitViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
    private val name = view.findViewById<TextView>(R.id.item_habit_name)
    private val color = view.findViewById<View>(R.id.item_habit_view_color)
    private val description = view.findViewById<TextView>(R.id.item_habit_description)
    private val periodicity = view.findViewById<TextView>(R.id.item_habit_periodicity)
    private val priority = view.findViewById<TextView>(R.id.item_habit_priority)
    private val type = view.findViewById<TextView>(R.id.item_habit_type)

    fun populate(habit: Habit) {
        name.text = habit.name
        color.setBackgroundColor(habit.color)
        description.text = habit.description
        periodicity.text = habit.count.toString() + " " + habit.date.toString()
        priority.text = habit.priority.toString()
        type.text = habit.type.toString()
    }
}
