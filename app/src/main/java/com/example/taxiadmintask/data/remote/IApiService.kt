package com.example.taxiadmintask.data.remote

import com.example.taxiadmintask.data.model.PostResponse
import com.example.taxiadmintask.data.model.Types
import com.example.taxiadmintask.data.model.login.LoginRequest
import com.example.taxiadmintask.data.model.login.LoginResponse
import retrofit2.Response
import retrofit2.http.*


const val BASE_URL = "https://taxiadmin.ddns.mksat.net/taxi/api/v2/disp/"
const val LOGIN_URL = "login"
const val ORDER_URL = "orders"
// Endpoints

interface IApiService {

    @POST(LOGIN_URL)
    suspend fun login(@Body request: LoginRequest): Response<LoginResponse>

    @POST(ORDER_URL)
    suspend fun fetchPosts(@Body types: Types, @Header("Authorization") token: String): Response<PostResponse>

    //@Header("Authorization") token: String
}