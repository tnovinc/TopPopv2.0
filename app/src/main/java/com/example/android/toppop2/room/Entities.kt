package com.example.android.toppop2.room

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.android.toppop2.models.AlbumTrack

@Entity
data class Tracks(
    @PrimaryKey
    val id: Int,
    val title: String,
    val duration: Int,
    val position: Int = -1,
    val artistName: String,
    val artistPicture: String,
    val albumId: Int
)

@Entity
data class Albums(
    @PrimaryKey
    val id: Int,
    val title: String,
    val cover: String,
    val artistName: String
)