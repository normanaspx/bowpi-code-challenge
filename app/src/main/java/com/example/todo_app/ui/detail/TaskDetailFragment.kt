package com.example.todo_app.ui.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.todo_app.R
import com.example.todo_app.databinding.FragmentTaskDetailBinding
import com.example.todo_app.model.Task

class TaskDetailFragment : Fragment() {

    private val args: TaskDetailFragmentArgs by navArgs()

    private var _binding: FragmentTaskDetailBinding? =null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_task_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding = FragmentTaskDetailBinding.bind(view)

        val task: Task = args.task

        binding.textView.text = task.title
        binding.desc.text =  task.desc
        binding.taskCheckbox.isChecked = task.completed
        binding.date.text = task.dueDate.toString()

    }

}