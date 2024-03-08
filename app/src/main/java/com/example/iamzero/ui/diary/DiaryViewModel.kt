package com.example.iamzero.ui.diary

import android.net.Uri
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.iamzero.data.diary.DiaryRepositoryImpl
import com.example.iamzero.data.diary.Post
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DiaryViewModel( private val diaryRepository: DiaryRepositoryImpl) : ViewModel(){

    private var _diaryContent :MutableLiveData<Post> = MutableLiveData()
    val diaryContent: MutableLiveData<Post> get() = _diaryContent
    private var _imageList :MutableLiveData<List<Uri>> = MutableLiveData()
    val imageList: MutableLiveData<List<Uri>> get() = _imageList
    fun getDiary(id: Long){
        viewModelScope.launch(Dispatchers.IO){
            diaryRepository.getPost(id).let{
                _diaryContent.postValue(it)
            }
        }
    }

    fun writeDiary(post: Post){
        viewModelScope.launch(Dispatchers.IO){
            diaryRepository.insertPost(post)
        }
    }

    fun editDiary(post: Post){
        viewModelScope.launch(Dispatchers.IO){
            diaryRepository.editPost(post)
        }
    }

fun deleteDiary(post: Post){
        viewModelScope.launch(Dispatchers.IO){
            diaryRepository.deletePost(post)
        }
    }

}