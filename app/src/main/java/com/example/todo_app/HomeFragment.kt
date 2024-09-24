package com.example.todo_app

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.todo_app.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {

    private lateinit var adapter: TaskAdapter
    private var _binding: FragmentHomeBinding?=null
    private val binding get() = _binding!!

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

        val list = listOf<Task>(
            Task(title = "hola"),
            Task(title = "hola"),
            Task(title = "hola"),
            Task(title = "hola"),
            Task(title = "hola")
        )

        adapter = TaskAdapter(list)
        binding.apply {
            tasksList.setHasFixedSize(true)
            tasksList.adapter = adapter
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}