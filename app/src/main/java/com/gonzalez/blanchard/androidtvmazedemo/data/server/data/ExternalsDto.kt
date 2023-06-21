package com.gonzalez.blanchard.androidtvmazedemo.data.server.data

import kotlinx.serialization.Serializable

@Serializable
data class ExternalsDto(
    val imdb: String?,
    val thetvdb: Int?,
    val tvrage: Int?
)