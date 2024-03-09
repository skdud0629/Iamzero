package com.example.iamzero.ui.diary

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.iamzero.DiaryViewModelFactory
import com.example.iamzero.data.diary.DiaryRepositoryImpl
import com.example.iamzero.databinding.ActivityPostBinding

class PostActivity : AppCompatActivity() {
    private lateinit var _binding: ActivityPostBinding
    private val binding get() = _binding
    private val viewModel by viewModels<DiaryViewModel> { DiaryViewModelFactory(DiaryRepositoryImpl(this)) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityPostBinding.inflate(layoutInflater)
        val postImageList=viewModel.diaryContent.value?.img!!
        viewModel.getDiary(intent.getLongExtra("id", 0))
        binding.postContentContainer.adapter = PostImagePagerAdapter(postImageList, this)
        binding.postTv.text =viewModel.diaryContent.value?.content
        setContentView(binding.root)
    }


}