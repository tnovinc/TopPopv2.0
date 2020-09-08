package com.example.android.toppop2.retrofit.dto

import com.example.android.toppop2.models.ChartTrack
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ChartDTO(val tracks: ChartTracksDTO)

@JsonClass(generateAdapter = true)
data class ChartTracksDTO(val data: List<ChartTrackDTO>)

@JsonClass(generateAdapter = true)
data class ChartTrackDTO(
    val id: Int,
    val title: String,
    val duration: Int,
    val position: Int,
    val artist: ChartArtistDTO,
    val album: ChartAlbumDTO
)

@JsonClass(generateAdapter = true)
data class ChartArtistDTO(
        val id: Int,
        val name: String,
        val picture: String)

@JsonClass(generateAdapter = true)
data class ChartAlbumDTO(
        val id: Int,
        val title: String,
        val cover: String)

fun ChartDTO.asListOfTracks() : List<ChartTrack>{
    return tracks.data.map {
        ChartTrack(
            id = it.id,
            title = it.title,
            duration = it.duration,
            position = it.position,
            artistName = it.artist.name,
            artistPicture = it.artist.picture,
            albumId = it.album.id
        )
    }
}