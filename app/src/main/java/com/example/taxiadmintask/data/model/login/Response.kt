package com.example.taxiadmintask.data.model.login


import com.google.gson.annotations.SerializedName
import java.util.*

data class Response(
    var account: Int,
    var email: String,
    var fam: String,
    var id: Int,
    @SerializedName("id_taxi")
    var idTaxi: Int,
    var key: String,
    var name: String,
    var number: Int,
    @SerializedName("reward_account")
    var rewardAccount: Int,
    var right: Objects
)