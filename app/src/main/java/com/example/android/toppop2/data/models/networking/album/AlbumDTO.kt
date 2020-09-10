package com.example.android.toppop2.data.models.networking.album

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class AlbumDTO(
    val id: Int,
    val title: String,
    @Json(name = "cover_big")
    val cover: String,
    val artist: AlbumArtistDTO,
    val tracks: AlbumTracksDTO
)

