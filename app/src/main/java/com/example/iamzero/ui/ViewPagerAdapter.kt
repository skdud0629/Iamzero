package com.example.iamzero.ui

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.iamzero.ui.calender.CalendarFragment
import com.example.iamzero.ui.diary.DiaryFragment

class ViewPagerAdapter(fragment: FragmentActivity) : FragmentStateAdapter(fragment){
    override fun getItemCount(): Int = PAGES_NUM
    override fun createFragment(position: Int): Fragment {

        return when(position){
            0 -> { CalendarFragment() }
            1 -> { DiaryFragment() }
            else -> throw Exception()
        }
    }
    companion object {
        private const val PAGES_NUM = 2
    }
}