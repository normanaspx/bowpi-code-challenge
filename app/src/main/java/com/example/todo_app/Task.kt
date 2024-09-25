package com.example.todo_app

import java.util.Date
import java.util.UUID

data class Task(val id: String = UUID.randomUUID().toString(),
                var title: String = "",
                var desc: String = "",
                var dueDate: Date = Date()
)