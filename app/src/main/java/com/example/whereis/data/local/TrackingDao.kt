package com.example.whereis.data.local

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.whereis.model.TrackingData

@Dao
interface TrackingDao{

    @Query("SELECT * from tracking_data")
    fun getAll(): LiveData<List<TrackingData>>

    @Query("SELECT * from tracking_data WHERE trackingNum = :trackingNum")
    fun getDetailData(trackingNum: String?) : LiveData<TrackingData>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertData(trackingData: TrackingData)

    @Query("DELETE FROM tracking_data WHERE trackingNum = :trackingNum")
    fun deleteData(trackingNum: String)
}