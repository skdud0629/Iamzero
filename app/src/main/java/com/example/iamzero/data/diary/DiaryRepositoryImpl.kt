package com.example.iamzero.data.diary

import android.content.Context


class DiaryRepositoryImpl(context: Context) : DiaryRepository {
    private val database: DiaryDatabase

    init {
        database = DiaryDatabase.getInstance(context)!!
    }

    override suspend fun getAllPost(): List<Post> {
        return database.postDao().getAllPost()
    }

    override suspend fun getPost(id: Long): Post {
        return database.postDao().getPost(id)
    }

    override suspend fun insertPost(post: Post) {
        return database.postDao().insertPost(post)
    }

    override suspend fun editPost(post: Post) {
        return database.postDao().editPost(post)
    }

    override suspend fun deletePost(post: Post) {
        return database.postDao().deletePost(post)
    }
}