package com.example.taxiadmintask.data.remote

import android.content.Context
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {

    fun getApiService(context: Context): IApiService {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)

        val requestInterceptor = Interceptor {
            val url = it.request()
                .url
                .newBuilder()
                .build()
            val request = it.request()
                .newBuilder()
                .url(url)
                .addHeader("Content-Type", "application/json")
                .build()
            return@Interceptor it.proceed(request)
        }
        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(requestInterceptor)
            .addInterceptor(httpLoggingInterceptor)
            .build()

        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(BASE_URL)
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(IApiService::class.java)
    }
}