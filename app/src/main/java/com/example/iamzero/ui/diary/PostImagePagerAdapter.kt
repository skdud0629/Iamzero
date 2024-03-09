package com.example.iamzero.ui.diary

import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.iamzero.R
class PostImagePagerAdapter(var postContents: List<String>, val context: Context) :
    RecyclerView.Adapter<PostImagePagerAdapter.PagerViewHolder>() {
    inner class PagerViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder
        (LayoutInflater.from(parent.context).inflate(R.layout.item_post_content, parent, false)) {
        val postContent: ImageView = itemView.findViewById(R.id.iv_post_content)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = PagerViewHolder((parent))

    override fun getItemCount(): Int = postContents.size

    override fun onBindViewHolder(holder: PagerViewHolder, position: Int) {
        //holder.postContent.setImageResource()
        val item= postContents[position]
        Glide.with(context).load(Uri.parse(item))
            .override(500,1280)
            .into(holder.postContent)
    }
}