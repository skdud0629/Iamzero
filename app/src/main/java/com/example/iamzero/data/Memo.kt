package com.example.iamzero.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Memo(
    @PrimaryKey val id: Int,
    val content: String,
    val date: String
)
