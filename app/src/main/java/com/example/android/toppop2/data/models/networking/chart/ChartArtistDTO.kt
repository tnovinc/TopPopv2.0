package com.example.android.toppop2.data.models.networking.chart

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ChartArtistDTO(
    val id: Int,
    val name: String,
    val picture: String)
