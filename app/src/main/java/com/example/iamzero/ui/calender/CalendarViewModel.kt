package com.example.iamzero.ui.calender

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.iamzero.data.Memo
import com.example.iamzero.data.MemoRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CalendarViewModel(private val memoRepository: MemoRepository) : ViewModel() {

    fun getMemo(id: Long) {
        viewModelScope.launch(Dispatchers.IO) {
            memoRepository.getMemo(id)
        }
    }

    fun writeMemo(memo: Memo) {
        viewModelScope.launch(Dispatchers.IO) {
            memoRepository.insertMemo(memo)
        }
    }

    fun deleteMemo(memo: Memo) {
        viewModelScope.launch(Dispatchers.IO) {
            memoRepository.deleteMemo(memo)
        }
    }
}