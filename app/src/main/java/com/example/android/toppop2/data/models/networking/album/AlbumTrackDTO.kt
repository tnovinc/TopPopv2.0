package com.example.android.toppop2.data.models.networking.album

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class AlbumTrackDTO(
    val id: Int,
    val title: String,
    val duration: Int
)