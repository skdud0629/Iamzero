package com.example.iamzero

import android.app.Application
import com.example.iamzero.data.MemoRepositoryImpl

class CalendarApplication : Application() {
    //private val applicationScope = CoroutineScope(SupervisorJob())
    //val database by lazy { MemoDatabase.getInstance(this) }
    val repository by lazy { MemoRepositoryImpl(this) }
}