package com.example.taxiadmintask.utils

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import com.example.taxiadmintask.R

class SessionManager(context: Context) {
    private var prefs: SharedPreferences = context.getSharedPreferences(context.getString(R.string.app_name), Context.MODE_PRIVATE)

    companion object {
        const val LOGIN_TOKEN = "login_token"
    }

    fun saveAuthToken(keys: MutableSet<String>) {
        val editor = prefs.edit()
        editor.putStringSet(LOGIN_TOKEN, keys)
        editor.apply()
    }

    fun fetchAuthToken(): MutableSet<String>? {
        return prefs.getStringSet(LOGIN_TOKEN, null)
    }

}