package com.example.android.toppop2.data.models.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Tracks(
    @PrimaryKey
    val id: Int,
    val title: String,
    val duration: Int,
    val position: Int,
    val artistName: String,
    val artistPicture: String,
    val albumId: Int
)