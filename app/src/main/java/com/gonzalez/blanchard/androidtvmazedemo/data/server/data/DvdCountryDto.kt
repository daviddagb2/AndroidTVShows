package com.gonzalez.blanchard.androidtvmazedemo.data.server.data

import kotlinx.serialization.Serializable

@Serializable
data class DvdCountryDto(
    val code: String?,
    val name: String?,
    val timezone: String?
)