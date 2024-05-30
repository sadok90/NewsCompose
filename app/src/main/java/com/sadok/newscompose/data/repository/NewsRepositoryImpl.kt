package com.sadok.newscompose.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.sadok.newscompose.data.remote.NewsAPI
import com.sadok.newscompose.data.remote.NewsPagingSource
import com.sadok.newscompose.domain.model.Article
import com.sadok.newscompose.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class NewsRepositoryImpl(
    private val newsAPI: NewsAPI
): NewsRepository {
    override fun getNews(sources: List<String>): Flow<PagingData<Article>> {
        return Pager(
            config = PagingConfig(10),
            pagingSourceFactory = {
                NewsPagingSource(
                    newsAPI = newsAPI,
                    sources = sources.joinToString(separator = ",")
                )
            }
        ).flow
    }

}