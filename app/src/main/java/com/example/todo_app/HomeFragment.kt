package com.example.todo_app

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.todo_app.databinding.FragmentHomeBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase


class HomeFragment : Fragment() {

    private lateinit var adapter: TaskAdapter
    private var _binding: FragmentHomeBinding?=null
    private val binding get() = _binding!!
    private lateinit var database: DatabaseReference
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding = FragmentHomeBinding.bind(view)


        database = Firebase.database.reference


        val list = listOf<Task>(
            Task(title = "hola"),
            Task(title = "hola"),
            Task(title = "hola"),
            Task(title = "hola"),
            Task(title = "hola"),
                    Task(title = "hola"),
            Task(title = "hola"),
            Task(title = "hola"),
            Task(title = "hola")
        )

        database.child("users").child(list[0].id.toString()).setValue(list[0])

        adapter = TaskAdapter(list)
        binding.apply {
            tasksList.setHasFixedSize(true)
            tasksList.adapter = adapter
        }

        binding.fab.setOnClickListener {
            findNavController().navigate(
                HomeFragmentDirections.actionHomeFragmentToTaskDetailFragment()
            )
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}