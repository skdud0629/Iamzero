package com.example.iamzero.ui.diary

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.activityViewModels
import com.example.iamzero.DiaryViewModelFactory
import com.example.iamzero.data.diary.DiaryRepositoryImpl
import com.example.iamzero.databinding.FragmentDiaryBinding


class DiaryFragment : Fragment() {
    private lateinit var _binding: FragmentDiaryBinding
    private lateinit var requestActivityResult: ActivityResultLauncher<Intent>
    private val viewModel: DiaryViewModel by activityViewModels {
        DiaryViewModelFactory(repository)
    }

    private lateinit var repository : DiaryRepositoryImpl

    private val binding get() = _binding
    private lateinit var postAdapter: DiaryAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        repository = DiaryRepositoryImpl(requireContext())
        _binding = FragmentDiaryBinding.inflate(layoutInflater)
        getDiaryList()
        requestActivity()
        binding.uploadBtn.setOnClickListener {
            val intent = Intent(Intent.ACTION_PICK)//== intent.action = Intent.ACTION_GET_CONTENT
            intent.type = "image/*" // intent.data = MediaStore.Images.Media.EXTERNAL_CONTENT_URI
            intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true)

            requestActivityResult.launch(intent)

        }
        postAdapter = DiaryAdapter {
            val intent = Intent(requireContext(), PostActivity::class.java)
            intent.putExtra("id", it.id)
            startActivity(intent)
        }
        binding.postRv.adapter =postAdapter
        return binding.root
    }

    override fun onResume() {
        super.onResume()
        getDiaryList()
    }
    private fun getDiaryList(){

        viewModel.getAllDiary()
        viewModel.postList.observe(viewLifecycleOwner) {
            postAdapter.submitList(it)
        }

    }

    private fun requestActivity() {
        var currentList :  ArrayList<String> = ArrayList()
        requestActivityResult =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { it ->
                if (it.resultCode == Activity.RESULT_OK && it.data != null) { //갤러리 캡쳐 결과값  && it.data?.data != null
                    val clipData = it?.data?.clipData
                    var selectedImageUri: Uri
                    currentList = ArrayList()
                    if (clipData == null) {
                        selectedImageUri = it?.data?.data!!
                        currentList.add(selectedImageUri.toString())
                    } else {
                            val count = clipData.itemCount
                            for (i in 0 until count) {
                                selectedImageUri = clipData.getItemAt(i).uri
                                currentList.add(selectedImageUri.toString())
                            }

                    }
                    viewModel.imageList.value = currentList
                }
                val intent= Intent(requireContext(), UploadActivity::class.java)
                intent.putExtra("imageList",  currentList as ArrayList<String>)
                startActivity(intent)

            }
    }

}