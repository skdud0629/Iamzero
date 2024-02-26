package com.example.iamzero.ui.diary

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.example.iamzero.R
import com.example.iamzero.databinding.ActivityDiaryPostBinding
import com.example.iamzero.databinding.ActivityMainBinding
import com.example.iamzero.ui.ViewPagerAdapter

class DiaryPostActivity : AppCompatActivity() {
    private lateinit var _binding: ActivityDiaryPostBinding
    val binding get() = _binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityDiaryPostBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.postContentContainer.adapter=PostImagePagerAdapter(getAespaMembers())
    }

    private fun getAespaMembers(): ArrayList<Int> {
        return arrayListOf<Int>(
            R.drawable.sharp_android_24,
            R.drawable.ic_launcher_background
        )
    }
}