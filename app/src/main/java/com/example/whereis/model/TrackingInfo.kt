package com.example.whereis.model

import com.google.gson.annotations.SerializedName

data class TrackingInfo(
    @SerializedName("TrackingInfo")
    val complete:String,
    val estimate:String,
    val invoiceNo:String,
    val itemName:String,
    val level:String,
    val orderNumber1:String,
    val productInfo:String,
    val result:String,
    val trackingDetails: List<TrackingDetail>
)

data class TrackingDetail(
    val code: String,
    val kind: String,
    val level: String,
    val manName: String,
    val manPic: String,
    val remark:String
)