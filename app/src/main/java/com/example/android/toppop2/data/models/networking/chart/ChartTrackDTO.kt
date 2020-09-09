package com.example.android.toppop2.data.models.networking.chart

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ChartTrackDTO(
    val id: Int,
    val title: String,
    val duration: Int,
    val position: Int,
    val artist: ChartArtistDTO,
    val album: ChartAlbumDTO
)