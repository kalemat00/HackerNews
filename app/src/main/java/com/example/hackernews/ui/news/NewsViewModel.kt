package com.example.hackernews.ui.news

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hackernews.ui.retrofit.HackerNewsApi
import com.example.hackernews.ui.retrofit.ItemsDto
import kotlinx.coroutines.launch

class NewsViewModel: ViewModel() {
    private val _listOfItems: MutableLiveData<List<ItemsDto>> = MutableLiveData()
    val listOfItems: LiveData<List<ItemsDto>>
        get() = _listOfItems

    fun getNewsIds(){
        viewModelScope.launch {
            try {
                val listOfIds: MutableList<Int> = mutableListOf()
                listOfIds.addAll(HackerNewsApi.getNewsId())

                val listOfItemsFromApi: MutableList<ItemsDto> = mutableListOf()
                for(i: Int in 0..30){
                    listOfItemsFromApi.add(HackerNewsApi.getItem(listOfIds[i]))
                    _listOfItems.value = listOfItemsFromApi
                }

            } catch (e: Exception) {
                Log.e("exeption", "$e")
                throw IllegalArgumentException()
            }
        }
    }
}