package com.sadok.newscompose.domain.repository

import androidx.paging.PagingData
import com.sadok.newscompose.domain.model.Article
import kotlinx.coroutines.flow.Flow

interface NewsRepository {
    fun getNews(sources: List<String>): Flow<PagingData<Article>>
}