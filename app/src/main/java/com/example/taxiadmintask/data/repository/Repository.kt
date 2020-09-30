package com.example.taxiadmintask.data.repository

import com.example.taxiadmintask.data.model.Types
import com.example.taxiadmintask.data.model.login.LoginRequest
import com.example.taxiadmintask.data.remote.RemoteDataSource

class Repository(private val remoteDataSource: RemoteDataSource) {

    suspend fun getLoginResponse(request: LoginRequest) = remoteDataSource.getLoginResponse(request)

    suspend fun getPostResponse(types: Types, token: String) = remoteDataSource.getPostResponse(types, token)

}