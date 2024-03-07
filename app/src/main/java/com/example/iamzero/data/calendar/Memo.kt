package com.example.iamzero.data.calendar

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Memo(
    @PrimaryKey val id: Long,
    val content: String?
)
