package com.gonzalez.blanchard.androidtvmazedemo.data.server.data

import kotlinx.serialization.Serializable

@Serializable
data class CountryDto(
    val code: String?,
    val name: String?,
    val timezone: String?
)