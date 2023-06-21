package com.gonzalez.blanchard.androidtvmazedemo.data.server.data

import kotlinx.serialization.Serializable

@Serializable
data class LinksDto(
    val nextepisodeDto: NextepisodeDto? = null,
    val previousepisodeDto: PreviousepisodeDto? = null,
    val self: SelfDto? = null
)