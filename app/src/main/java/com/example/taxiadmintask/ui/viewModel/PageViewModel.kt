package com.example.taxiadmintask.ui.viewModel

import android.app.Application
import androidx.lifecycle.*
import com.example.taxiadmintask.data.model.PostResponse
import com.example.taxiadmintask.data.model.Types
import com.example.taxiadmintask.data.model.login.LoginRequest
import com.example.taxiadmintask.data.model.login.LoginResponse
import com.example.taxiadmintask.data.remote.ApiClient
import com.example.taxiadmintask.data.remote.IApiService
import com.example.taxiadmintask.data.remote.RemoteDataSource
import com.example.taxiadmintask.data.repository.Repository
import com.example.weatherapp.utils.Resource
import kotlinx.coroutines.Dispatchers
import java.lang.Exception

class PageViewModel(application: Application) : AndroidViewModel(application) {
    private val apiClient: ApiClient = ApiClient()
    private val remoteDataSource: RemoteDataSource = RemoteDataSource(apiClient, application)
    private val repository: Repository = Repository(remoteDataSource)


    fun getLoginResponse(request: LoginRequest) = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = repository.getLoginResponse(request)))
        } catch (e: Exception) {
            emit(Resource.error(data = null, message = e.message ?: "Error Occurred!"))
        }
    }

    private val _index = MutableLiveData<String>()
    val currentToken: LiveData<String> = Transformations.map(_index) {
        it.toString()
    }

    fun getPostResponse(types: Types, token: String) = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = repository.getPostResponse(types, token)))
        } catch (e: Exception) {
            emit(Resource.error(data = null, message = e.message ?: "Error Occurred!"))
        }
    }

    fun setIndex(index: String) {
        _index.value = index
    }
}