package com.example.iamzero.data

interface MemoRepository {
    suspend fun insertMemo(memo: Memo)
    suspend fun deleteMemo(memo: Memo)

}
