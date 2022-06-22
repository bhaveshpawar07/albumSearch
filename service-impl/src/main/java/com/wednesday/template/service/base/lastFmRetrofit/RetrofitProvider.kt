package com.wednesday.template.service.base.lastFmRetrofit

import android.content.Context
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.Interceptor
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit

@OptIn(ExperimentalSerializationApi::class)
fun getLastFMRetrofit(context:Context, vararg interceptors : Interceptor):Retrofit{


    val okHttpClient = OkHttpClient().newBuilder().run {
        interceptors.forEach {
            addInterceptor(it)
        }
        build()
    }

    val baseUrl="https://ws.audioscrobbler.com/"
    val contentType = "application/json".toMediaType()
    val json= Json {
        ignoreUnknownKeys = true
        explicitNulls = false
    }

    return Retrofit.Builder()
        .client(okHttpClient)
        .baseUrl(baseUrl)
        .addConverterFactory(json.asConverterFactory(contentType))
        .build()



}