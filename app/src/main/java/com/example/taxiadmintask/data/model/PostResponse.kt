package com.example.taxiadmintask.data.model

import com.google.gson.annotations.SerializedName


data class PostResponse(
    @SerializedName("response")
    var response: List<Response>,
    @SerializedName("status")
    var status: Boolean
)