package com.example.whereis.data.local

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.whereis.model.TrackingData

@Dao
interface TrackingDao{

    @Query("SELECT * from tracking_data")
    fun getAll(): LiveData<List<TrackingData>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertData(trackingData: TrackingData)

    @Delete
    fun deleteData(trackingData: TrackingData)
}