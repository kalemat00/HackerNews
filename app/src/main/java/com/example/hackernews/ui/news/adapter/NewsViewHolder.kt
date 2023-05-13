package com.example.hackernews.ui.news.adapter

import android.annotation.SuppressLint
import androidx.recyclerview.widget.RecyclerView
import com.example.hackernews.databinding.NewsListItemBinding
import com.example.hackernews.ui.retrofit.ItemsDto

class NewsViewHolder(private val binding: NewsListItemBinding): RecyclerView.ViewHolder(binding.root){
    @SuppressLint("SetTextI18n")
    fun bind(dataToBind: ItemsDto){
        binding.apply {
            titleText.text = dataToBind.title
            authorText.text = "by " + dataToBind.by
        }
    }
}