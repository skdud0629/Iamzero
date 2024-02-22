package com.example.iamzero.data

import java.util.Date

interface MemoRepository {
    suspend fun getMemo(date: Date) :Memo
    suspend fun insertMemo(memo: Memo)
    suspend fun deleteMemo(memo: Memo)

}
