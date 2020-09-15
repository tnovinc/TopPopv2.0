package com.example.android.toppop2.data.models.networking.album

import com.google.gson.annotations.SerializedName

//@JsonClass(generateAdapter = true)
data class AlbumDTO(
    val id: Int,
    val title: String,
    @SerializedName("cover_big")
    val cover: String,
    val artist: AlbumArtistDTO,
    val tracks: AlbumTracksDTO
)

