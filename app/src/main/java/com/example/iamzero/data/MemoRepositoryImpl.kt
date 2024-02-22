package com.example.iamzero.data

import android.content.Context
import java.util.Date


class MemoRepositoryImpl(context: Context) : MemoRepository {
    private val database: MemoDatabase
    init {
        database = MemoDatabase.getInstance(context)!!
    }
    override suspend fun getMemo(date: Date): Memo {
        return database.memoDao().getMemo(date)
    }
    override suspend fun insertMemo(memo: Memo) {
        return database.memoDao().insertMemo(memo)
    }

    override suspend fun deleteMemo(memo: Memo) {
        return database.memoDao().deleteMemo(memo)
    }

}