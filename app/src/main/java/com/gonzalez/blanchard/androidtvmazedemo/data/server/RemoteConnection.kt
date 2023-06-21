package com.gonzalez.blanchard.androidtvmazedemo.data.server

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.create

object RemoteConnection {

    private val okHttpClient = HttpLoggingInterceptor().run {
        level = HttpLoggingInterceptor.Level.BODY
        OkHttpClient.Builder().addInterceptor(this).build()
    }
    private var json: Json = Json {
        allowStructuredMapKeys = true
        prettyPrint = true
        coerceInputValues = true
        allowSpecialFloatingPointValues = true
        isLenient = true
        ignoreUnknownKeys = true
    }

    private val jsonConvertFactory = json.asConverterFactory("application/json".toMediaType())

    private val builder = Retrofit.Builder()
        .baseUrl("https://api.tvmaze.com/")
        .client(okHttpClient)
        .addConverterFactory(jsonConvertFactory)
        .build()

    val service: RemoteService = builder.create()
}