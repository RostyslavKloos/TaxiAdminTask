package com.example.taxiadmintask.data.remote

import android.content.Context
import com.example.taxiadmintask.data.model.Types
import com.example.taxiadmintask.data.model.login.LoginRequest
import retrofit2.http.Header

class RemoteDataSource(private val apiClient: ApiClient, private val context: Context): BaseDataSource() {
    suspend fun getLoginResponse(request: LoginRequest) = getResult { apiClient.getApiService(context).login(request) }

    suspend fun getPostResponse(types: Types, token: String) = getResult { apiClient.getApiService(context).fetchPosts(types, token)
    }
}