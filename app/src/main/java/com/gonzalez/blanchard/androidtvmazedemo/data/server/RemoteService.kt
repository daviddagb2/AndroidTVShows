package com.gonzalez.blanchard.androidtvmazedemo.data.server

import com.gonzalez.blanchard.androidtvmazedemo.data.server.data.TvShowDto
import retrofit2.http.GET

interface RemoteService {

    @GET("shows")
    suspend fun getShows(): List<TvShowDto>

}