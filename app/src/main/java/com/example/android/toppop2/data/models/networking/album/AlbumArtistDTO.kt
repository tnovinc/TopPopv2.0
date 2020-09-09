package com.example.android.toppop2.data.models.networking.album

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class AlbumArtistDTO(
    val id: Int,
    val name: String,
    val picture: String
)