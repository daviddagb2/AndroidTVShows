package com.gonzalez.blanchard.androidtvmazedemo.data.server.data.mappers

import com.gonzalez.blanchard.androidtvmazedemo.data.server.data.TvShowDto
import com.gonzalez.blanchard.androidtvmazedemo.domain.models.ImageItem
import com.gonzalez.blanchard.androidtvmazedemo.domain.models.TvShowItem

fun TvShowDto.toDomain() = TvShowItem(
    averageRuntime = averageRuntime?:0,
    ended = ended?:"",
    id = id?:0,
    image = image?.toDomain()?: ImageItem("",""),
    language = language?:"",
    name = name?:"",
    officialSite = officialSite?:"",
    premiered = premiered?:"",
    runtime = runtime?:0,
    status = status?:"",
    summary = summary?:"",
    type = type?:"",
    updated = updated?:0,
    url = url?:"",
    weight = weight?:0
)