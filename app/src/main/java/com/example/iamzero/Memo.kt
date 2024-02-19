package com.example.iamzero

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Memo(
    @PrimaryKey val id: Int?,
    val content: String,
    val date: String
) {
    constructor() : this(null, "제목", "")
}
