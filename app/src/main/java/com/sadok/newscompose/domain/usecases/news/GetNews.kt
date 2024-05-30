package com.sadok.newscompose.domain.usecases.news

import com.sadok.newscompose.domain.repository.NewsRepository

class GetNews(
   private val newsRepository: NewsRepository
) {
    operator fun invoke(sources: List<String> ) {
        newsRepository.getNews(sources)
    }
}