package com.example.iamzero.data.diary

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Post(
    @PrimaryKey
    val id: String,
    val img: String,
    val content: String
)
