package com.gonzalez.blanchard.androidtvmazedemo.data.repository

import com.gonzalez.blanchard.androidtvmazedemo.data.server.RemoteConnection
import com.gonzalez.blanchard.androidtvmazedemo.data.server.data.mappers.toDomain
import com.gonzalez.blanchard.androidtvmazedemo.domain.models.TvShowItem


class TvShowRepository() {

    suspend fun getHomeTvShows(): Map<String, List<TvShowItem>> {
        val tvShows = RemoteConnection.service.getShows().map { it.toDomain() }
        return tvShows.groupBy { "Home" }
    }

   /* suspend fun getCategories(): Map<Category, List<Movie>> {
        return Category.values().associateWith { category ->
            RemoteConnection
                .service
                .listPopularMovies(apiKey, category.id).results.map { it.toDomain() }
        }
    }*/
}