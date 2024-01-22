package com.example.iamzero

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.iamzero.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var _binding: ActivityMainBinding
    val binding get() = _binding
    private val viewPagerAdapter by lazy { ViewPagerAdapter(this) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding =ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.viewpagerContainer.adapter = viewPagerAdapter

        binding.practiceBottomNavi.setOnItemSelectedListener {
            when(it.itemId){
                R.id.action_calendar -> { binding.viewpagerContainer.currentItem = 0 }
                R.id.action_diary -> { binding.viewpagerContainer.currentItem = 1 }
            }
            true
        }

        binding.viewpagerContainer.registerOnPageChangeCallback(object: androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                binding.practiceBottomNavi.menu.getItem(position).isChecked = true
            }
        })
    }

}