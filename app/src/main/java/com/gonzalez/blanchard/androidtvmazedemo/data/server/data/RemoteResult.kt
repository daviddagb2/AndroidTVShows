package com.gonzalez.blanchard.androidtvmazedemo.data.server.data

import kotlinx.serialization.Serializable

@Serializable
data class RemoteResult(
    val list: List<TvShowDto>?
)