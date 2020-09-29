package com.example.taxiadmintask.data.remote

import android.content.Context
import com.example.taxiadmintask.data.remote.Interceptor.AuthInterceptor
import com.example.taxiadmintask.data.remote.Interceptor.HttpLoggingInterceptor
import com.github.simonpercic.oklog3.OkLogInterceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {
    private lateinit var apiService: IApiService
    private val interceptor = OkLogInterceptor.builder().build()
    val httpLoggingInterceptor = HttpLoggingInterceptor()

    fun getApiService(context: Context): IApiService {

        if (!::apiService.isInitialized) {
            val retrofit = Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient(context))
                .build()

            apiService = retrofit.create(IApiService::class.java)
        }
        return apiService
    }

    private fun okHttpClient(context: Context): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .addInterceptor(interceptor)
            .addInterceptor(AuthInterceptor(context))
            .build()
    }
}