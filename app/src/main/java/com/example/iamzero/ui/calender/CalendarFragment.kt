package com.example.iamzero.ui.calender

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.iamzero.databinding.FragmentCalendarBinding
import java.text.SimpleDateFormat
import java.util.Date

class CalendarFragment : Fragment() {
    private lateinit var _binding: FragmentCalendarBinding
    private val binding get() = _binding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentCalendarBinding.inflate(inflater, container, false)
        val dataFormat = SimpleDateFormat("yyyy년 MM월 dd일")
        val date: Date = Date(binding.calendarView.date)
        binding.calendarView.setOnDateChangeListener { view, year, month, dayOfMonth -> //calendar 날짜변환 이벤트
            val date = dataFormat.parse("${year}년 ${month+1}월 ${dayOfMonth}일")
            // binding.calendarDateText.text = dataFormat.format(date)
        }

        return binding.root
    }

}