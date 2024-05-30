package com.sadok.newscompose.data.remote

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.sadok.newscompose.domain.model.Article

class NewsPagingSource(
    private val newsAPI: NewsAPI,
    private val sources: String
): PagingSource<Int, Article>() {

    private var totalPageCount = 0

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Article> {
        val page = params.key ?: 1
        return try {
            val newsResponse = newsAPI.getNews(page = page, source= sources )
            totalPageCount += newsResponse.articles.size
            val articles = newsResponse.articles.distinctBy { it.title }
            return LoadResult.Page(
                data = articles,
                nextKey = if(totalPageCount == newsResponse.totalResults) null else page + 1,
                prevKey = null
            )

        } catch (e: Exception) {
            e.printStackTrace()
            return LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Article>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)

        }
    }



}