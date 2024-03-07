package com.example.iamzero.data.calendar

import android.content.Context


class MemoRepositoryImpl(context: Context) : MemoRepository {
    private val database: MemoDatabase
    init {
        database = MemoDatabase.getInstance(context)!!
    }
    override suspend fun getMemo(id: Long): Memo {
        return database.memoDao().getMemo(id)
    }
    override suspend fun insertMemo(memo: Memo) {
        return database.memoDao().insertMemo(memo)
    }

    override suspend fun deleteMemo(memo: Memo) {
        return database.memoDao().deleteMemo(memo)
    }

}