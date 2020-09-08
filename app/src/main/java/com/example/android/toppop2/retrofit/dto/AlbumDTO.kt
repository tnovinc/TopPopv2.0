package com.example.android.toppop2.retrofit.dto

import com.example.android.toppop2.models.Album
import com.example.android.toppop2.models.AlbumTrack
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class AlbumDTO(
    val id: Int,
    val title: String,
    val cover: String,
    val artist: AlbumArtistDTO,
    val tracks: AlbumTracksDTO
)

@JsonClass(generateAdapter = true)
data class AlbumTracksDTO(
    val data: List<AlbumTrackDTO>
)

@JsonClass(generateAdapter = true)
data class AlbumTrackDTO(
    val id: Int,
    val title: String,
    val duration: Int
)

@JsonClass(generateAdapter = true)
data class AlbumArtistDTO(
    val id: Int,
    val name: String,
    val picture: String
)

fun AlbumDTO.asAlbum(): Album {
    return Album(
        id = id,
        title = title,
        cover = cover,
        artistName = artist.name,
        tracks = tracks.data.map {
            AlbumTrack(
                id = it.id,
                title = it.title,
                duration = it.duration
            )
        }
    )
}