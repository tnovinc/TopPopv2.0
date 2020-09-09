package com.example.android.toppop2.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.android.toppop2.room.dao.AlbumDao
import com.example.android.toppop2.room.dao.ChartDao

@Database(entities = [Tracks::class, Albums::class, AlbumTracks::class], version = 1)
abstract class TopPopDatabase: RoomDatabase(){
    abstract val chartDao: ChartDao
    abstract val albumDao: AlbumDao
}

private lateinit var INSTANCE: TopPopDatabase

fun getDatabase(context: Context): TopPopDatabase{
    synchronized(TopPopDatabase::class.java) {
        if (!::INSTANCE.isInitialized) {
            INSTANCE = Room.databaseBuilder(
                context.applicationContext,
                TopPopDatabase::class.java,
                "toppop").build()
        }
    }
    return INSTANCE
}