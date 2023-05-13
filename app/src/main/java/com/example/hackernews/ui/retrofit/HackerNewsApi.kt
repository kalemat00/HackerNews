package com.example.hackernews.ui.retrofit

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object HackerNewsApi {
    private const val BASE_URL = "https://hacker-news.firebaseio.com/"

    private val client = OkHttpClient.Builder()
        .addInterceptor(
            HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY }
        )
        .build()

    private val retrofitHackerNews = Retrofit.Builder()
        .client(client)
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val hackerNewsService: HackerNewsService = retrofitHackerNews.create(HackerNewsService::class.java)


    suspend fun getNewsId(): List<Int> = hackerNewsService.getNews()

    suspend fun getTopsId(): List<Int> = hackerNewsService.getTops()

    suspend fun getBestsId(): List<Int> = hackerNewsService.getBests()

    suspend fun getItem(id: Int): ItemsDto = hackerNewsService.getItem(id)


}