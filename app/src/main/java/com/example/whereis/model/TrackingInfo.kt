package com.example.whereis.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class TrackingResponse(
    @SerializedName("TrackingInfo")
    val complete: String?,
    val estimate: String?,
    val invoiceNo: String,
    val itemName: String,
    val level: String,
    val orderNumber1: String?,
    val productInfo: String?,
    val result: String,
    val trackingDetails: List<TrackingDetail>,

    val status: Boolean,
    val msg: String,
    val code: Int

) : Serializable {

    fun isSuccessful() = code == 0

    fun toTrackingInfo(): TrackingInfo {
        return TrackingInfo(
            complete,
            estimate,
            invoiceNo,
            itemName,
            level,
            orderNumber1,
            productInfo,
            result,
            trackingDetails
        )
    }

    fun toError(): TrackingError {
        return TrackingError(
            status,
            msg,
            code
        )
    }
}

data class TrackingInfo(
    @SerializedName("TrackingInfo")
    val complete: String?,
    val estimate: String?,
    val invoiceNo: String,
    val itemName: String,
    val level: String,
    val orderNumber1: String?,
    val productInfo: String?,
    val result: String,
    val trackingDetails: List<TrackingDetail>
)

data class TrackingError(
    val status: Boolean?,
    val msg: String?,
    val code: Int?
)

data class TrackingDetail(
    val kind: String,
    val telno: String,
    val timeString: String,
    val where: String
) : Serializable