package com.example.taxiadmintask

import android.os.Bundle
import android.util.Log
import com.google.android.material.tabs.TabLayout
import androidx.viewpager.widget.ViewPager
import androidx.appcompat.app.AppCompatActivity
import com.example.taxiadmintask.data.model.PostResponse
import com.example.taxiadmintask.data.remote.ApiClient
import com.example.taxiadmintask.data.remote.SessionManager
import com.example.taxiadmintask.ui.main.SectionsPagerAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

const val testToken = "b1tf9cdg3ebl39a"

class MainActivity : AppCompatActivity() {
    private lateinit var apiClient: ApiClient
    private lateinit var sessionManager: SessionManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val sectionsPagerAdapter = SectionsPagerAdapter(this, supportFragmentManager)
        val viewPager: ViewPager = findViewById(R.id.view_pager)
        viewPager.adapter = sectionsPagerAdapter
        val tabs: TabLayout = findViewById(R.id.tabs)
        tabs.setupWithViewPager(viewPager)
        apiClient = ApiClient()
        sessionManager = SessionManager(this)

        fetchPosts()
    }

    private fun fetchPosts() {

        // Pass the token as parameter
        apiClient.getApiService(this).fetchPosts(listOf(1), token = "Bearer bz25e927zjpmqmpq")
            .enqueue(object : Callback<PostResponse> {
                override fun onFailure(call: Call<PostResponse>, t: Throwable) {
                    Log.i("resp", t.message.toString(), t)
                }

                override fun onResponse(call: Call<PostResponse>, response: Response<PostResponse>) {
                    Log.i("resp", response.body().toString())
                    Log.i("resp", sessionManager.fetchAuthToken().toString())
                    Log.i("resp", listOf(1).toString())
                }
            })
    }
}