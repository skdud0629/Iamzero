package com.example.iamzero.data.diary

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query


@Dao
interface PostDao {
    @Query("Select * from Post")
    fun getAllMemo(): Post
    @Insert
    fun insertMemo(memo: Post)
    @Query("SELECT * FROM Memo WHERE id = :id")
    fun getMemo(id: Long): Post
    @Delete
    fun deleteMemo(memo: Post)
}