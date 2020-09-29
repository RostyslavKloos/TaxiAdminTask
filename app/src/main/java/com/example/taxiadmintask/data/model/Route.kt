package com.example.taxiadmintask.data.model


import com.google.gson.annotations.SerializedName

data class Route(
    var entrance: String,
    var home: String,
    var id: Int,
    var lat: Double,
    var lng: Double,
    var sector: String,
    var street: String
)