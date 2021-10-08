package com.example.whereis.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class TrackingInfo(
    @SerializedName("TrackingInfo")
    val complete: String,
    val estimate: String,
    val invoiceNo: String,
    val itemName: String,
    val level: String,
    val orderNumber1: String,
    val productInfo: String,
    val result: String,
    val trackingDetails: List<TrackingDetail>
) : Serializable

data class TrackingDetail(
    val kind: String,
    val telno: String,
    val timeString: String,
    val where: String
) : Serializable