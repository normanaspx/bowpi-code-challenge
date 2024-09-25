package com.example.todo_app.model

import android.os.Parcelable
import com.google.firebase.database.Exclude
import kotlinx.parcelize.Parcelize
import java.util.Date
import java.util.UUID

@Parcelize
data class Task(val id: String = UUID.randomUUID().toString(),
                var title: String = "",
                var desc: String = "",
                var completed: Boolean = false,
                var dueDate: Date = Date()
) : Parcelable {
    @Exclude
    fun toMap(): Map<String, Any?> {
        return mapOf(
            "id" to id,
            "title" to title,
            "desc" to desc,
            "completed" to completed,
            "dueDate" to dueDate
        )
    }
}