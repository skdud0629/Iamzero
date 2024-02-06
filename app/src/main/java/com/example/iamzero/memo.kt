package com.example.iamzero

import androidx.room.PrimaryKey

class memo(@PrimaryKey val id: Int?,
           val content: String,
           val date: String){
    constructor(): this(null,"제목", "")
}
