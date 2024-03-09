package com.example.iamzero.ui.diary

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import com.example.iamzero.DiaryViewModelFactory
import com.example.iamzero.data.diary.DiaryRepositoryImpl
import com.example.iamzero.data.diary.Post
import com.example.iamzero.databinding.ActivityUploadBinding
import java.time.LocalDate

class UploadActivity : AppCompatActivity() {
    private lateinit var _binding: ActivityUploadBinding
    private val viewModel by viewModels<DiaryViewModel> { DiaryViewModelFactory(DiaryRepositoryImpl(this)) }
    val binding get() = _binding
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        _binding = ActivityUploadBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val imageList = intent.getStringArrayListExtra("imageList")
        val localDate: LocalDate = LocalDate.now()
        val id: Long = System.currentTimeMillis()
        binding.postContentContainer.adapter = PostImagePagerAdapter(imageList!!, this)

        binding.uploadBtn.setOnClickListener {
            val post = binding.postEt.text.toString()
            viewModel.uploadDiary(Post(id, localDate.toString(), imageList, post))
            finish()
        }
    }


}