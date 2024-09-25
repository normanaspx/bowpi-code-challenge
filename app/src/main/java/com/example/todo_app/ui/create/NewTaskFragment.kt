package com.example.todo_app.ui.create

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.todo_app.R
import com.example.todo_app.model.Task
import com.example.todo_app.databinding.FragmentNewTaskBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase


class NewTaskFragment : Fragment() {

    private var _binding: FragmentNewTaskBinding?=null
    private val binding get() = _binding!!
    private lateinit var database: DatabaseReference

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_new_task, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentNewTaskBinding.bind(view)

        database = Firebase.database.reference


        binding.fab1.setOnClickListener {

            val task = Task(title = binding.editText.text.toString(), desc = binding.desc.text.toString())
            database.child("users").child(task.id).setValue(task)
                .addOnCompleteListener{
                    findNavController().navigateUp()
                }
        }

    }
}