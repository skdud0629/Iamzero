package com.example.iamzero.ui.calender

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.example.iamzero.ViewModelFactory
import com.example.iamzero.data.Memo
import com.example.iamzero.data.MemoRepositoryImpl
import com.example.iamzero.databinding.FragmentCalendarBinding
import com.google.android.material.internal.ViewUtils.showKeyboard
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

    @SuppressLint("SimpleDateFormat", "RestrictedApi")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCalendarBinding.inflate(inflater, container, false)
        val calendar = Calendar.getInstance()
        var memoId = "${calendar.get(Calendar.YEAR)}${calendar.get(Calendar.MONTH) + 1}${
            calendar.get(Calendar.DAY_OF_MONTH)
        }"
        val dataFormat = SimpleDateFormat("yyyy년 MM월 dd일")
        val date: Date = Date(binding.calendarView.date)

        viewModel.date = dataFormat.format(date)
        viewModel.getMemo(memoId.toLong())
        binding.calendarView.setOnDateChangeListener { view, year, month, dayOfMonth ->
            memoId = "$year${month + 1}$dayOfMonth"
            viewModel.getMemo(memoId.toLong())
        }

        binding.writeBtn.setOnClickListener {
            val builder = AlertDialog.Builder(requireContext())
            val et: EditText = EditText(requireContext())
            et.setText(viewModel.memoContent.value)

            builder.setTitle("$date")
                .setView(et)
                .setPositiveButton("수정") { dialog, _ ->
                    binding.memoTv.text=et.text
                    viewModel.writeMemo(Memo(memoId.toLong(), et.text.toString()))
                    dialog.dismiss()
                }
                .setNegativeButton("취소") { dialog, _ ->
                    viewModel.memoContent.value = et.text.toString()
                    dialog.dismiss()
                }
            builder.show()

        }

        viewModel.memoContent.observe(viewLifecycleOwner) { content ->
            binding.memoTv.text = content
        }

        return binding.root
    }


}