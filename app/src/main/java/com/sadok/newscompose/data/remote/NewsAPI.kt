package com.sadok.newscompose.data.remote

import com.sadok.newscompose.data.remote.dto.NewsResponse
import com.sadok.newscompose.util.Constants.API_KEY
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsAPI {
    @GET("Everything")
    suspend fun getNews(
        @Query("page") page: Int,
        @Query("sources") source: String,
        @Query("apiKey") apiKey: String = API_KEY
    ) : NewsResponse
}