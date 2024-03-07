package com.example.iamzero.ui.diary

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.iamzero.R
import com.example.iamzero.data.diary.Post
import com.example.iamzero.databinding.ItemPostBinding

class DiaryAdapter(
    private val onItemClicked: (Post) -> Unit
) : ListAdapter<Post, DiaryAdapter.ViewHolder>(diffUtil) {

    inner class ViewHolder(private val binding: ItemPostBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Post) {

            Glide.with(binding.root.context)
                .load(item.img)
                .error(R.drawable.sharp_android_24)
                .circleCrop()
                .into(binding.postIv)


            binding.postIv.setOnClickListener {
                onItemClicked(item)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemPostBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(currentList[position])
    }

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<Post>() {

            override fun areItemsTheSame(oldItem: Post, newItem: Post): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Post, newItem: Post): Boolean {
                return oldItem == newItem
            }
        }

    }
}
