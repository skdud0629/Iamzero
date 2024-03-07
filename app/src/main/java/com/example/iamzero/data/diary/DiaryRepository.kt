package com.example.iamzero.data.diary

interface DiaryRepository {
    suspend fun getPost(id: Long): Post
    suspend fun editPost(post: Post)
    suspend fun deletePost(post: Post)
}