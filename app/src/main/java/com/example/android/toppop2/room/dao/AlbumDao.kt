package com.example.android.toppop2.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.android.toppop2.room.AlbumTracks
import com.example.android.toppop2.room.Albums

@Dao
interface AlbumDao{

    @Query("select * from albums where id = :albumId")
    fun getAlbum(albumId: Int): Albums

    @Query("select * from albumTracks where albumId = :albumId")
    fun getAlbumTracks(albumId: Int): List<AlbumTracks>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAlbum(vararg albums: Albums)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAlbumTracks(albumTracks: List<AlbumTracks>)
}