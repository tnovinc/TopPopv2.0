package com.example.android.toppop2.models


data class Album(
    val id: Int,
    val title: String,
    val cover: String,
    val artistName: String,
    val tracks: List<AlbumTrack>
)

data class AlbumTrack(
    val id: Int,
    val title: String,
    val duration: Int
)