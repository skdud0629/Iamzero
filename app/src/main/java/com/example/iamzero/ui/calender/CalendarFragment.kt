package com.example.iamzero.ui.calender

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.iamzero.ViewModelFactory
import com.example.iamzero.data.Memo
import com.example.iamzero.data.MemoRepositoryImpl
import com.example.iamzero.databinding.FragmentCalendarBinding
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date

class CalendarFragment : Fragment() {
    private lateinit var _binding: FragmentCalendarBinding
    private lateinit var repository: MemoRepositoryImpl
    private lateinit var viewModel: CalendarViewModel

    override fun onAttach(context: Context) {
        super.onAttach(context)
        repository = MemoRepositoryImpl(requireContext())
        viewModel = ViewModelFactory(repository).create(CalendarViewModel::class.java)
    }

    private val binding get() = _binding
    @SuppressLint("SimpleDateFormat")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCalendarBinding.inflate(inflater, container, false)
        val calendar = Calendar.getInstance()
        var memoId = "${calendar.get(Calendar.YEAR)}${calendar.get(Calendar.MONTH) + 1}${calendar.get(Calendar.DAY_OF_MONTH)}"

        viewModel.getMemo(memoId.toLong())
        binding.calendarView.setOnDateChangeListener { view, year, month, dayOfMonth ->
            memoId="$year${month+1}$dayOfMonth"
            viewModel.getMemo(memoId.toLong())
        }

        binding.writeBtn.setOnClickListener {
            buttonState(true)
        }

        binding.checkBtn.setOnClickListener {
            buttonState(false)
            viewModel.memoContent.value= binding.memoEt.text.toString()
            viewModel.writeMemo(Memo(memoId.toLong(),viewModel.memoContent.value))
            binding.memoTv.visibility = View.VISIBLE
            binding.memoEt.visibility=View.GONE
        }

        binding.cancelBtn.setOnClickListener {
            buttonState(false)
        }

        viewModel.memoContent.observe(viewLifecycleOwner) { content ->
            binding.memoTv.text = content
            binding.memoEt.setText(content)
        }

        return binding.root
    }

    private fun buttonState(isEditing: Boolean){
        if(isEditing){
            binding.memoTv.visibility = View.GONE
            binding.writeBtn.visibility = View.GONE
            binding.memoEt.visibility = View.VISIBLE
            binding.cancelBtn.visibility = View.VISIBLE
            binding.checkBtn.visibility = View.VISIBLE
        } else {
            binding.memoTv.visibility = View.VISIBLE
            binding.writeBtn.visibility = View.VISIBLE
            binding.memoEt.visibility = View.GONE
            binding.cancelBtn.visibility = View.GONE
            binding.checkBtn.visibility = View.GONE
        }
    }


}