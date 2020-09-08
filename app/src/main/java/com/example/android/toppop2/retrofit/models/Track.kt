package com.example.android.toppop2.retrofit.models

data class Track(
    val id: Int,
    val title: String,
    val duration: Int,
    val position: Int,
    val artistName: String,
    val artistPicture: String,
    val albumId: Int,
    val albumTitle: String,
    val albumCover: String
)