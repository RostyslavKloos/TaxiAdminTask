package com.example.taxiadmintask.ui.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.taxiadmintask.data.model.login.LoginRequest
import com.example.taxiadmintask.databinding.LoginFragmentBinding
import com.example.taxiadmintask.ui.viewModel.PageViewModel
import com.example.taxiadmintask.utils.SessionManager
import com.example.weatherapp.utils.Resource

class LoginActivity : AppCompatActivity() {
    private var _binding: LoginFragmentBinding? = null
    private val binding get() = _binding!!

    private lateinit var sessionManager: SessionManager
    private lateinit var viewModel: PageViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = LoginFragmentBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        sessionManager = SessionManager(this)

        viewModel = ViewModelProvider(this).get(PageViewModel::class.java)
        setupUI()
    }
    private fun setupUI() {
        binding.btnLogin.setOnClickListener {
            loginRequest()
        }
    }

    private fun loginRequest() {
        val email = binding.edtEmail.text.toString()
        val password = binding.edtPassword.text.toString()

        viewModel.getLoginResponse(LoginRequest(email, password)).observe(this, {
            it?.let { resource ->
                when (resource.status) {
                    Resource.Status.SUCCESS -> {
                        it.data?.let {
                            val keyArray: MutableSet<String> = mutableSetOf()
                            it.data?.response?.forEach {
                                keyArray.add(it.key)
                            }
                            binding.tvTest.text = keyArray.toString()
                            Log.i("MyTag", it.data?.response.toString())
                            sessionManager.saveAuthToken(keyArray)
                            val intent = Intent(this, MainActivity::class.java)
                            startActivity(intent)
                        }
                    }
                    Resource.Status.ERROR -> {
                        //
                    }
                    Resource.Status.LOADING -> {
                        //
                    }
                }
            }
        })
    }


}