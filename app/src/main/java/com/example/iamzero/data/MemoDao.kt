package com.example.iamzero.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import java.util.Date

@Dao
interface MemoDao {
    @Query("Select * from Memo")
    fun getAllMemo(): Memo
    @Query("SELECT * FROM Memo WHERE id = :id")
    fun getMemo(id: Long): Memo
    @Delete
    fun deleteMemo(memo: Memo)
    @Insert(onConflict = OnConflictStrategy.REPLACE) //동일한 PrimaryKey 가 있을 경우 덮어쓰기
    fun insertMemo(memo: Memo)
}