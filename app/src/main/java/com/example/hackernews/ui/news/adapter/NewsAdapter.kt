package com.example.hackernews.ui.news.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hackernews.databinding.NewsListItemBinding
import com.example.hackernews.ui.retrofit.ItemsDto


class NewsAdapter(private val listToShow: List<ItemsDto>): RecyclerView.Adapter<NewsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val binding: NewsListItemBinding = NewsListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NewsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.bind(listToShow[position])
    }
    override fun getItemCount(): Int = listToShow.size
}