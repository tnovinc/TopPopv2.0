package com.example.android.toppop2.room.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.android.toppop2.room.Tracks

@Dao
interface ChartDao{

    @Query("select * from tracks")
    fun getChartTracks(): LiveData<List<Tracks>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertChartTracks(charts: List<Tracks>)

}