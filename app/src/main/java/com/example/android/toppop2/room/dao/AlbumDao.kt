package com.example.android.toppop2.room.dao

import androidx.room.Dao
import androidx.room.Query
import com.example.android.toppop2.room.Albums
import com.example.android.toppop2.room.Tracks

@Dao
interface AlbumDao{

    @Query("select * from tracks where albumId = :albumId")
    fun getAlbumTracks(albumId: Int): List<Tracks>

    @Query("select * from albums where id = :albumId")
    fun getAlbum(albumId: Int): Albums
}