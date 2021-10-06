package com.example.whereis.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tracking_data")
data class TrackingData(
    @PrimaryKey
    @ColumnInfo(name = "trackingNum")
    val trackingNum: String,
    @ColumnInfo(name = "company")
    val company: String,
    @ColumnInfo(name = "company_code")
    val company_code: String
)