package com.example.iamzero.ui.diary

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.iamzero.databinding.FragmentDiaryBinding


class DiaryFragment : Fragment() {
    private lateinit var _binding : FragmentDiaryBinding
    private val binding get() = _binding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDiaryBinding.inflate(layoutInflater)
        return binding.root
    }



}