package com.example.android.toppop2.data.models.networking.album

import com.squareup.moshi.JsonClass

//@JsonClass(generateAdapter = true)
data class AlbumTracksDTO(
    val data: List<AlbumTrackDTO>
)