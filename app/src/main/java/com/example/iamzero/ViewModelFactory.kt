package com.example.iamzero

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.iamzero.data.calendar.MemoRepositoryImpl
import com.example.iamzero.ui.calender.CalendarViewModel


class ViewModelFactory(private val repository: MemoRepositoryImpl) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CalendarViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return CalendarViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}