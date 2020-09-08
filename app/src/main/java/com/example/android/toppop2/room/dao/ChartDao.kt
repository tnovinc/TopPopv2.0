package com.example.android.toppop2.room.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.example.android.toppop2.models.ChartTrack

@Dao
interface ChartDao{

    @Query("select * from tracks where position>0")
    fun getChart(): LiveData<List<ChartTrack>>

}