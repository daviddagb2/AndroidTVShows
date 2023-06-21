package com.gonzalez.blanchard.androidtvmazedemo.data.server.data

import kotlinx.serialization.Serializable

@Serializable
data class ScheduleDto(
    val days: List<String>?,
    val time: String?
)