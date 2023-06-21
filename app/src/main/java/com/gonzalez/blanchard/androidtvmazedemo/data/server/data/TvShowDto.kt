package com.gonzalez.blanchard.androidtvmazedemo.data.server.data

import kotlinx.serialization.Serializable

@Serializable
data class TvShowDto(
    val _links: LinksDto?,
    val averageRuntime: Int?,
    val dvdCountry: DvdCountryDto?,
    val ended: String?,
    val externals: ExternalsDto?,
    val genres: List<String>?,
    val id: Int?,
    val image: ImageDto?,
    val language: String?,
    val name: String?,
    val network: NetworkDto?,
    val officialSite: String?,
    val premiered: String?,
    val rating: RatingDto?,
    val runtime: Int?,
    val schedule: ScheduleDto?,
    val status: String?,
    val summary: String?,
    val type: String?,
    val updated: Int?,
    val url: String?,
    val webChannel: WebChannelDto?,
    val weight: Int?
)