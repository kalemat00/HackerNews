package com.example.hackernews.ui.retrofit

data class ItemsDto(
    val id: Int,
    val deleted: Boolean,
    val type: String,
    val `by`: String,
    val time: Int,
    val text: String,
    val dead: Boolean,
    val parent: Int,
    val poll: Int,
    val kids: List<Int>,
    val url: String,
    val score: Int,
    val title: String,
    val part: List<Int>,
    val descendants: Int
)

//TODO add mapper