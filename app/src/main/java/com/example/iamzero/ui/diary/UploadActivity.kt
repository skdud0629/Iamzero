package com.example.iamzero.ui.diary

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.iamzero.databinding.ActivityDiaryPostBinding

class UploadActivity : AppCompatActivity() {
    private lateinit var _binding: ActivityDiaryPostBinding
    val binding get() = _binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityDiaryPostBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.postContentContainer.adapter=PostImagePagerAdapter(,Context)
    }


}