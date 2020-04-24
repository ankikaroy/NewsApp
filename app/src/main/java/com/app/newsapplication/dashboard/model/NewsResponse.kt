package com.app.newsapplication.dashboard.model

data class NewsResponse(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)