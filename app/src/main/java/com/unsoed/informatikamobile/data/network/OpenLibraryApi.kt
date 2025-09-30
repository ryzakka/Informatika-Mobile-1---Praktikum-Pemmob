package com.unsoed.informatikamobile.data.network

import retrofit2.http.GET
import retrofit2.http.Query
import com.unsoed.informatikamobile.data.model.SearchResponse
import retrofit2.Response

interface OpenLibraryApi {
    @GET(value="search.json")
    suspend fun searchBooks(
        @Query(value = "q") query: String,
        @Query(value = "page") page: Int
    ): Response<SearchResponse>
}