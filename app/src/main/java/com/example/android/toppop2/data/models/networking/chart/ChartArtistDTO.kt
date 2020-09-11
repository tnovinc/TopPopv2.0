package com.example.android.toppop2.data.models.networking.chart

import com.google.gson.annotations.SerializedName
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

//@JsonClass(generateAdapter = true)
data class ChartArtistDTO(
    val id: Int,
    val name: String,
    @SerializedName("picture_big")
    val picture: String)
