package com.example.whereis.data.local

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.whereis.model.TrackingData

@Dao
interface TrackingDao{

    @Query("SELECT * from tracking_data")
    suspend fun getAll(): List<TrackingData>

    @Query("SELECT * from tracking_data WHERE trackingNum = :trackingNum")
    suspend fun getDetailData(trackingNum: String?) : TrackingData

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertData(trackingData: TrackingData)

    @Query("DELETE FROM tracking_data WHERE trackingNum = :trackingNum")
    fun deleteData(trackingNum: String)
}