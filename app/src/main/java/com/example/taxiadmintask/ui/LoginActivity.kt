package com.example.taxiadmintask.ui

import android.content.Intent
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Website.URL
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.taxiadmintask.MainActivity
import com.example.taxiadmintask.R
import com.example.taxiadmintask.data.model.login.LoginRequest
import com.example.taxiadmintask.data.model.login.LoginResponse
import com.example.taxiadmintask.data.remote.ApiClient
import com.example.taxiadmintask.data.remote.SessionManager
import com.google.gson.internal.bind.TypeAdapters.URL
import kotlinx.android.synthetic.main.activity_login.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

const val email = "vue@test.ua"
const val password = "12345"

class LoginActivity : AppCompatActivity() {
    private lateinit var sessionManager: SessionManager
    private lateinit var apiClient: ApiClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        apiClient = ApiClient()
        sessionManager = SessionManager(this)


        btn_login.setOnClickListener {
            loginRequest()
            val intent = Intent(this@LoginActivity, MainActivity::class.java)
            startActivity(intent)
        }
    }

    fun loginRequest() {

        apiClient.getApiService(this).login(LoginRequest(email = email, password = password))
            .enqueue(object : Callback<LoginResponse> {
                override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                    Log.e("NewTag", t.message, t)
                    tv_test.text = t.message
                }

                override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                    val loginResponse = response.body()
                    val keyArray: MutableSet<String> = mutableSetOf()

                    if (loginResponse?.status == true) {
                        loginResponse.response.forEach {
                            keyArray.add(it.key)
                        }
                        sessionManager.saveAuthToken(keyArray)
                        tv_test.text = keyArray.toString()
                    } else {
                        tv_test.text = "Error"
                    }
                }
            })
    }
}