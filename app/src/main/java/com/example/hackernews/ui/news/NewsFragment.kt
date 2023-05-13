package com.example.hackernews.ui.news

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hackernews.databinding.FragmentNewsBinding
import com.example.hackernews.ui.news.adapter.NewsAdapter

class NewsFragment : Fragment() {
    private lateinit var binding: FragmentNewsBinding
    private lateinit var viewModel: NewsViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this)[NewsViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNewsBinding.inflate(inflater)
        binding.newsRecyclerView.layoutManager = LinearLayoutManager(requireContext())

        viewModel.listOfItems.observe(viewLifecycleOwner ){items ->
            binding.newsRecyclerView.adapter = NewsAdapter(items)
        }

        viewModel.getNewsIds()

        binding.swipeRefreshLayout.setOnRefreshListener {
            binding.swipeRefreshLayout.isRefreshing = false
            viewModel.getNewsIds()
            binding.newsRecyclerView.adapter?.notifyDataSetChanged()
        }


        return binding.root
    }


}