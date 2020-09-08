package com.example.android.toppop2.models

data class ChartTrack(
    val id: Int,
    val title: String,
    val duration: Int,
    val position: Int,
    val artistName: String,
    val artistPicture: String,
    val albumId: Int
)