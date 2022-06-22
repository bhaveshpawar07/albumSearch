package com.wednesday.template.service.base.lastFmRetrofit.interceptors

import com.wednesday.template.service.impl.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response

class LastFMApiKeyInterceptor : Interceptor{
    companion object {
        private const val API_KEY = "api_key"
    }

    override fun intercept(chain: Interceptor.Chain): Response {
        val lastFmApiKey = BuildConfig.AUDIO_SCROBBLER_API_KEY
        val request = chain.request()
        val url = request.url.newBuilder().addQueryParameter(API_KEY,lastFmApiKey).build()
        val newReq=request.newBuilder().url(url).build()
        return chain.proceed(newReq)
    }
}