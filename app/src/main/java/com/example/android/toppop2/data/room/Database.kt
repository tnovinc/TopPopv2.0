package com.example.android.toppop2.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.android.toppop2.data.models.database.AlbumTracks
import com.example.android.toppop2.data.models.database.Albums
import com.example.android.toppop2.data.models.database.Tracks
import com.example.android.toppop2.data.room.dao.AlbumDao
import com.example.android.toppop2.data.room.dao.ChartDao

@Database(entities = [Tracks::class, Albums::class, AlbumTracks::class], version = 1)
abstract class TopPopDatabase: RoomDatabase(){
    abstract val chartDao: ChartDao
    abstract val albumDao: AlbumDao
}