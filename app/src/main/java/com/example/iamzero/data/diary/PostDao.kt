package com.example.iamzero.data.diary

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow


@Dao
interface PostDao {
    @Query("SELECT * FROM Post")
    fun getAllPost(): List<Post>
    @Query("SELECT * FROM Post WHERE id = :id")
    fun getPost(id: Long): Flow<Post>
    @Insert
    fun insertPost(post: Post)
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun editPost(post: Post)
    @Delete
    fun deletePost(memo: Post)
}