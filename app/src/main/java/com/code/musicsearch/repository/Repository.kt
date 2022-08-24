package com.code.musicsearch

import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory.create
import retrofit2.http.GET
import retrofit2.http.Query

class DataRepository {
    private val baseUrl = "https://itunes.apple.com/"

    suspend fun getSongData(term: String, limit: String): SongData? {
        val retrofit = Retrofit
            .Builder().baseUrl(baseUrl)
            .addConverterFactory(create())
            .build()

        return retrofit.create(SongDataEndpoint::class.java).callSongData(term, limit).body()
    }
}

interface SongDataEndpoint {
    @GET("search")
    suspend fun callSongData(
        @Query("term") term: String,
        @Query("limit") limit: String
    ): Response<SongData>
}
