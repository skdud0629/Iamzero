package com.example.iamzero.ui.calender

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.iamzero.data.calendar.Memo
import com.example.iamzero.data.calendar.MemoRepositoryImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CalendarViewModel(private val memoRepository: MemoRepositoryImpl) : ViewModel() {

    private val _memoContent: MutableLiveData<String?> = MutableLiveData()
    val memoContent: MutableLiveData<String?> get() = _memoContent
    var date = ""
    fun getMemo(id: Long) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val memoData = memoRepository.getMemo(id).content// 비동기적으로 데이터를 가져온 후, 값을 할당해야 함.
                _memoContent.postValue(memoData)

            } catch (e: Exception) {
                // 데이터를 가져오는 동안 예외가 발생한 경우 처리
                Log.e("Error CalendarViewModel", "Error fetching memo", e)
                _memoContent.postValue(null)
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