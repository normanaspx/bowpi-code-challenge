package com.example.todo_app

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.todo_app.databinding.ListItemBinding

class TaskAdapter(private var itemsList: List<Task>?) : RecyclerView.Adapter<TaskAdapter.ViewHolder>() {


    class ViewHolder(private val itemBinding: ListItemBinding) :RecyclerView.ViewHolder(itemBinding.root){
        fun bind(task: Task) {
            itemBinding.taskTitle.text = "hola"
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