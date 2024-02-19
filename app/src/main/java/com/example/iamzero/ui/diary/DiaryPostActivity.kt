package com.example.iamzero.ui.diary

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.iamzero.databinding.FragmentDiaryPostBinding

class DiaryPostActivity : AppCompatActivity() {
    private lateinit var _binding : FragmentDiaryPostBinding
    val binding get() = _binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}