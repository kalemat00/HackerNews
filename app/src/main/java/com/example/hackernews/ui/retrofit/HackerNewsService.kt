package com.example.hackernews.ui.retrofit

import retrofit2.http.GET
import retrofit2.http.Path

interface HackerNewsService {
    @GET("v0/newstories.json")
    suspend fun getNews(): List<Int>

    @GET("v0/topstories.json")
    suspend fun getTops(): List<Int>

    @GET("v0/beststories.json")
    suspend fun getBests(): List<Int>

    @GET("v0/item/{id}.json")
    suspend fun getItem(@Path("id") itemId: Int): ItemsDto

    //TODO add something that turn id into the actual news
}