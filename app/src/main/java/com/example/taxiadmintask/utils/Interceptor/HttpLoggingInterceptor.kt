package com.example.taxiadmintask.utils.Interceptor

import okhttp3.Interceptor
import okhttp3.Response

class HttpLoggingInterceptor: Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        request = request.newBuilder()
            .addHeader("Content-Type", "application/json")
            .build()
        return chain.proceed(request)
    }
}