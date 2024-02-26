package com.example.iamzero.ui.diary

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.iamzero.R
import com.example.iamzero.ui.calender.CalendarFragment

class PostImagePagerAdapter(var postContents: ArrayList<Int>) :
    RecyclerView.Adapter<PostImagePagerAdapter.PagerViewHolder>() {
    inner class PagerViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder
        (LayoutInflater.from(parent.context).inflate(R.layout.item_post_content, parent, false)) {
        val postContent: ImageView = itemView.findViewById(R.id.iv_post_content)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = PagerViewHolder((parent))

    override fun getItemCount(): Int = postContents.size

    override fun onBindViewHolder(holder: PagerViewHolder, position: Int) {
        holder.postContent.setImageResource(postContents[position])
    }
}