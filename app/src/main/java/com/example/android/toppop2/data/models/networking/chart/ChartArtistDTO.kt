package com.example.android.toppop2.data.models.networking.chart

import com.google.gson.annotations.SerializedName

//@JsonClass(generateAdapter = true)
data class ChartArtistDTO(
    val id: Int,
    val name: String,
    @SerializedName("picture_big")
    val picture: String)
