package com.example.iamzero

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.iamzero.databinding.FragmentDiaryPostBinding

class DiaryPostFragment : Fragment() {
    private lateinit var _binding : FragmentDiaryPostBinding
    val binding get() = _binding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDiaryPostBinding.inflate(layoutInflater)
        return binding.root
    }

}