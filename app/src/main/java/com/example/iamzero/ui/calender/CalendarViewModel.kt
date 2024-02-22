package com.example.iamzero.ui.calender

import android.app.Application
import android.content.Context
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.iamzero.data.Memo
import com.example.iamzero.data.MemoRepository
import com.example.iamzero.data.MemoRepositoryImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.Date

class CalendarViewModel(private val memoRepository: MemoRepositoryImpl) : ViewModel() {

    private val _memoContent: MutableLiveData<String> = MutableLiveData()
    val memoContent: MutableLiveData<String> get() = _memoContent
    val date = ""
    fun getMemo(date: Date) {
        viewModelScope.launch(Dispatchers.IO) {
            val memoData= memoRepository.getMemo(date).toString()//비동기적으로 데이터를 가져온 후, 값을 할당해야 함.
            _memoContent.postValue(memoData)
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