package com.example.iamzero.data

import java.util.Date

interface MemoRepository {
    suspend fun getMemo(id: Long) :Memo
    suspend fun insertMemo(memo: Memo)
    suspend fun deleteMemo(memo: Memo)

}
