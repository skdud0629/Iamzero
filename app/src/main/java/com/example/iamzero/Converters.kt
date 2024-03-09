package com.example.iamzero

import androidx.room.TypeConverter
import com.example.iamzero.data.diary.Post
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class Converters {
    @TypeConverter
    fun listToJson(value: List<Post>?) = Gson().toJson(value)

    @TypeConverter
    fun jsonToList(value: String) = Gson().fromJson(value, Array<Post>::class.java).toList()

    @TypeConverter
    fun stringListToJson(value: ArrayList<String>?) = Gson().toJson(value)

    @TypeConverter
    fun jsonToStringList(value: String): ArrayList<String>? {
        val listType = object : TypeToken<ArrayList<String>>() {}.type
        return Gson().fromJson(value, listType)
    }
}