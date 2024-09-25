package com.example.todo_app

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.todo_app.databinding.ListItemBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class TaskAdapter(private var itemsList: List<Task>?
    ) : RecyclerView.Adapter<TaskAdapter.ViewHolder>() {


    class ViewHolder(private val itemBinding: ListItemBinding
    ) :RecyclerView.ViewHolder(itemBinding.root){
        fun bind(task: Task) {
            var database: DatabaseReference = Firebase.database.reference
            itemBinding.taskTitle.text = task.title
            itemBinding.taskCheckbox.setOnCheckedChangeListener { buttonView, isChecked ->
                //if (isChecked) {
                    database.child("users").child(task.id).child("completed").setValue(true)
               // }
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
        }
    }

    override fun getItemCount(): Int {
        return itemsList?.size ?: 0
    }
}