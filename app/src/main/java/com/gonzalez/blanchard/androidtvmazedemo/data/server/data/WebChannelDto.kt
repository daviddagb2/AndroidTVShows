package com.gonzalez.blanchard.androidtvmazedemo.data.server.data

import kotlinx.serialization.Serializable

@Serializable
data class WebChannelDto(
    val countryDto: CountryDto? = null,
    val id: Int?,
    val name: String?,
    val officialSite: String?
)