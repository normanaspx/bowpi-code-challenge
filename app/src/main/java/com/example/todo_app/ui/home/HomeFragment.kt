package com.example.todo_app.ui.home

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.todo_app.R
import com.example.todo_app.model.Task
import com.example.todo_app.databinding.FragmentHomeBinding
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class HomeFragment : Fragment() {

    @Inject
    lateinit var firebaseDatabase: DatabaseReference

    private lateinit var adapter: TaskAdapter
    private var _binding: FragmentHomeBinding?=null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding = FragmentHomeBinding.bind(view)

        val list =  mutableListOf<Task>()

        val postListener = object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                list.clear()
                if(dataSnapshot.exists()){
                    for(snapshot: DataSnapshot in dataSnapshot.children){
                        list.add(snapshot.getValue(Task::class.java) as Task)
                    }
                    adapter = TaskAdapter(list){
                        findNavController().navigate(
                            HomeFragmentDirections.actionHomeFragmentToTaskDetailFragment2(it)
                        )
                    }
                    binding.apply {
                        tasksList.setHasFixedSize(true)
                        tasksList.adapter = adapter
                    }
                }
            }

            override fun onCancelled(databaseError: DatabaseError) {
                Log.w("Error", "loadPost:onCancelled", databaseError.toException())
            }
        }
        firebaseDatabase.child("users").addValueEventListener(postListener)

        binding.fab.setOnClickListener {
            findNavController().navigate(
                HomeFragmentDirections.actionHomeFragmentToTaskDetailFragment()
            )
        }
    }

}