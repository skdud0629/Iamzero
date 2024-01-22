package com.example.iamzero

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class DiaryPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment){
    override fun getItemCount(): Int = PAGES_NUM
    override fun createFragment(position: Int): Fragment {

        return when(position){

            else -> throw Exception()
        }
    }
    companion object {
        private const val PAGES_NUM = 3
    }
}