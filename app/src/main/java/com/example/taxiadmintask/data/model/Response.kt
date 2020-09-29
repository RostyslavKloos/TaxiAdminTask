package com.example.taxiadmintask.data.model


import com.google.gson.annotations.SerializedName

data class Response(
    var advanced: Any,
    @SerializedName("car_type")
    var carType: Int,
    var comment: String,
    @SerializedName("date_time")
    var dateTime: String,
    var id: Int,
    var phone: String,
    var price: String,
    var routes: List<Route>,
    var status: Int,
    var type: Int
)