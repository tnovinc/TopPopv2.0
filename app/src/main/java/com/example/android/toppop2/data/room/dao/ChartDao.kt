package com.example.android.toppop2.data.room.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.android.toppop2.data.models.database.Tracks

@Dao
interface ChartDao{

    @Query("select * from tracks order by position")
    fun getChartTracks(): LiveData<List<Tracks>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertChartTracks(charts: List<Tracks>)

    @Query("delete from tracks")
    fun deleteAll()

}