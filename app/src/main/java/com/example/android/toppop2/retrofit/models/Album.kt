package com.example.android.toppop2.retrofit.models

data class Album(
    val id: Int,
    val title: String,
    val cover: String,
    val artistName: String,
    val artistPicture: String,
    val tracks: List<AlbumTrack>
)