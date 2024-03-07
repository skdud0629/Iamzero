package com.example.iamzero

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.iamzero.data.calendar.MemoRepositoryImpl
import com.example.iamzero.data.diary.DiaryRepositoryImpl
import com.example.iamzero.ui.calender.CalendarViewModel
import com.example.iamzero.ui.diary.DiaryViewModel


class MemoViewModelFactory(private val repository: MemoRepositoryImpl) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CalendarViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return CalendarViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
class DiaryViewModelFactory(private val repository: DiaryRepositoryImpl) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DiaryViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return DiaryViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}