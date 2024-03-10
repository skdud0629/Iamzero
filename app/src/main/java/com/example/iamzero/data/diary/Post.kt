package com.example.iamzero.data.diary

import android.net.Uri
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.ArrayList

@Entity
data class Post(
    @PrimaryKey
    val id: Long,
    val date: String,
    val img: List<String>?,
    val content: String
)
