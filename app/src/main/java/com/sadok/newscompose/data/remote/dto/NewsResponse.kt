package com.sadok.newscompose.data.remote.dto

import com.sadok.newscompose.domain.model.Article


data class NewsResponse(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)