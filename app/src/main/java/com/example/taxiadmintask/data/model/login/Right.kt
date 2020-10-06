package com.example.taxiadmintask.data.model.login


import com.google.gson.annotations.SerializedName

data class Right(
    @SerializedName("admin_complaints")
    var adminComplaints: Boolean,
    @SerializedName("assign_call")
    var assignCall: Boolean,
    var bookkeeping: Boolean,
    @SerializedName("client_finance")
    var clientFinance: Boolean,
    @SerializedName("client_profile")
    var clientProfile: Boolean,
    @SerializedName("client_push")
    var clientPush: Boolean,
    @SerializedName("delete_client")
    var deleteClient: Boolean,
    @SerializedName("driver_finance")
    var driverFinance: Boolean,
    @SerializedName("driver_priority")
    var driverPriority: Boolean,
    @SerializedName("driver_profile")
    var driverProfile: Boolean,
    @SerializedName("driver_shifts")
    var driverShifts: Boolean,
    @SerializedName("edit_prize_ride")
    var editPrizeRide: Boolean,
    @SerializedName("excel_export")
    var excelExport: Boolean,
    @SerializedName("hand_pausing")
    var handPausing: Boolean,
    @SerializedName("made_orders")
    var madeOrders: Boolean,
    @SerializedName("map_qset_gps")
    var mapQsetGps: Boolean,
    @SerializedName("moving_queue")
    var movingQueue: Boolean,
    @SerializedName("remove_call")
    var removeCall: Boolean,
    @SerializedName("remove_from_sector")
    var removeFromSector: Boolean,
    @SerializedName("return_false")
    var returnFalse: Boolean,
    @SerializedName("set_in_sector")
    var setInSector: Boolean,
    var settings: Boolean,
    var stats: Boolean,
    @SerializedName("view_resumes")
    var viewResumes: Boolean,
    @SerializedName("view_users")
    var viewUsers: Boolean
)