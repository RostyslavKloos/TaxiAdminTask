package com.example.taxiadmintask.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import java.io.Serializable

data class PostResponse(
    @SerializedName("response")
    var response: List<Response>,
    @SerializedName("status")
    var status: Boolean
): Serializable