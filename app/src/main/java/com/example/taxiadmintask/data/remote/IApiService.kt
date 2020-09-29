package com.example.taxiadmintask.data.remote

import com.example.taxiadmintask.data.model.PostResponse
import com.example.taxiadmintask.data.model.login.LoginRequest
import com.example.taxiadmintask.data.model.login.LoginResponse
import retrofit2.Call
import retrofit2.http.*


// Endpoints
// Hello


interface IApiService {

    @POST(Constants.LOGIN_URL)
    fun login(@Body request: LoginRequest): Call<LoginResponse>

    @POST(Constants.ORDER_URL)
    fun fetchPosts(@Body types: List<Int>, @Header("Authorization") token: String): Call<PostResponse>

}