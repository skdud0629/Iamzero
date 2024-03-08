package com.example.iamzero.ui.diary

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.example.iamzero.DiaryViewModelFactory
import com.example.iamzero.data.calendar.MemoRepositoryImpl
import com.example.iamzero.data.diary.DiaryRepositoryImpl
import com.example.iamzero.databinding.FragmentDiaryBinding


class DiaryFragment : Fragment() {
    private lateinit var _binding: FragmentDiaryBinding
    private lateinit var requestActivityResult: ActivityResultLauncher<Intent>
    private lateinit var viewModel: DiaryViewModel
    private lateinit var repository : DiaryRepositoryImpl

    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        repository = DiaryRepositoryImpl(requireContext())
        _binding = FragmentDiaryBinding.inflate(layoutInflater)
        viewModel = DiaryViewModelFactory(repository).create(DiaryViewModel::class.java)
        requestActivity()
        binding.uploadBtn.setOnClickListener {
            val intent = Intent(Intent.ACTION_PICK)//== intent.action = Intent.ACTION_GET_CONTENT
            intent.type = "image/*" // intent.data = MediaStore.Images.Media.EXTERNAL_CONTENT_URI
            intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true)

            requestActivityResult.launch(intent)

        }
        return binding.root
    }

    private fun requestActivity() {
        requestActivityResult =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { it ->
                if (it.resultCode == Activity.RESULT_OK && it.data != null) { //갤러리 캡쳐 결과값  && it.data?.data != null
                    val clipData = it?.data?.clipData
                    val clipDataSize = clipData?.itemCount
                    var selectedImageUri: Uri
                    val currentList : MutableList<Uri> = mutableListOf()
                    if (clipData == null) { //이미지를 하나만 선택할 경우 clipData가 null이 올수 있음
                        selectedImageUri = it?.data?.data!!
                        currentList.add(selectedImageUri)
                    } else {
                            val count = clipData.itemCount
                            for (i in 0 until count) { //선택 한 사진수만큼 반복
                                selectedImageUri = clipData.getItemAt(i).uri
                                currentList.add(selectedImageUri)
                            }

                    }
                    viewModel.imageList.value = currentList
                }
            }
    }

}