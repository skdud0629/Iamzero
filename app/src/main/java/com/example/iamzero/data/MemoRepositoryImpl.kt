package com.example.iamzero.data

class MemoRepositoryImpl(
    private val database: MemoDatabase
) : MemoRepository {
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