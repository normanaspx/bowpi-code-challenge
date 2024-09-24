package com.example.todo_app

import java.util.Date
import java.util.UUID

data class Task(val id: UUID = UUID.randomUUID(),
                var title: String = "",
                var desc: String = "",
                var dueDate: Date = Date()
)