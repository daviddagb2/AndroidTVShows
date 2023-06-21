package com.gonzalez.blanchard.androidtvmazedemo.data.server.data.mappers

import com.gonzalez.blanchard.androidtvmazedemo.data.server.data.ImageDto
import com.gonzalez.blanchard.androidtvmazedemo.domain.models.ImageItem

fun ImageDto.toDomain() = ImageItem(
    medium = medium?:"",
    original = original?:""
)