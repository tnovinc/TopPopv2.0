package com.example.android.toppop2.data.models.ui


data class Album(
    val id: Int,
    val title: String,
    val cover: String,
    val artistName: String,
    val tracks: List<AlbumTrack>
)