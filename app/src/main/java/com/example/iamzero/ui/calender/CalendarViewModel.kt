package com.example.iamzero.ui.calender

import android.app.Application
import android.content.Context
import android.util.Log
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
    fun getMemo(id: Long) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val memoData = memoRepository.getMemo(id).toString() // 비동기적으로 데이터를 가져온 후, 값을 할당해야 함.
                _memoContent.postValue(memoData)
            } catch (e: Exception) {
                // 데이터를 가져오는 동안 예외가 발생한 경우 처리
                Log.e("Error CalendarViewModel", "Error fetching memo", e)
               // _memoContent.postValue("Error fetching memo: ${e.message}")
            }
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