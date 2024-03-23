package com.example.iamzero.data.diary

import kotlinx.coroutines.flow.Flow

interface DiaryRepository {
    suspend fun getAllPost(): List<Post>
    suspend fun getPost(id: Long): Flow<Post>
    suspend fun insertPost(post: Post)
    suspend fun editPost(post: Post)
    suspend fun deletePost(post: Post)
}