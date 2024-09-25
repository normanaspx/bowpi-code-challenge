package com.example.todo_app.ui.home

import android.graphics.Paint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.todo_app.model.Task
import com.example.todo_app.databinding.ListItemBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class TaskAdapter(private var itemsList: List<Task>?,
                  private val clickCallback: ((Task) -> Unit)?
    ) : RecyclerView.Adapter<TaskAdapter.ViewHolder>() {


    class ViewHolder(private val itemBinding: ListItemBinding
    ) :RecyclerView.ViewHolder(itemBinding.root){
        fun bind(task: Task) {

            var database: DatabaseReference = Firebase.database.reference
            itemBinding.taskTitle.text = task.title
            itemBinding.taskCheckbox.setOnCheckedChangeListener(null)
            itemBinding.taskCheckbox.isChecked = task.completed

            if (task.completed) {
                itemBinding.taskTitle.apply {
                    paintFlags = paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
                }
            }

            itemBinding.taskCheckbox.setOnCheckedChangeListener { buttonView, isChecked ->
                if (isChecked) {
                    itemBinding.taskTitle.apply {
                        paintFlags = paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
                    }
                    database.child("users").child(task.id).child("completed").setValue(true)
                }else{
                    database.child("users").child(task.id).child("completed").setValue(false)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val itemBinding = ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = itemsList?.get(position)
        if (item != null) {
            holder.bind(item)
            holder.itemView.setOnClickListener() {
                clickCallback?.invoke(item)
            }
        }
    }

    override fun getItemCount(): Int {
        return itemsList?.size ?: 0
    }
}