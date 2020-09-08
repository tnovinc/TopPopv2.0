package com.example.android.toppop2.retrofit.models

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class AlbumDTO(
    val id: Int,
    val title: String,
    val cover: String,
    val artist: AlbumArtist,
    val tracks: AlbumTracks)

@JsonClass(generateAdapter = true)
data class AlbumTracks(
    val data: List<AlbumTrack>
)

@JsonClass(generateAdapter = true)
data class AlbumTrack(
    val id: Int,
    val title: String,
    val duration: Int
)

@JsonClass(generateAdapter = true)
data class AlbumArtist(
    val id: Int,
    val name: String,
    val picture: String
)

fun AlbumDTO.asAlbum(): Album{
    return Album(
        id = id,
        title = title,
        cover = cover,
        artistName = artist.name,
        artistPicture = artist.picture,
        tracks = tracks.data.map {
            AlbumTrack(
                id = it.id,
                title = it.title,
                duration = it.duration
            )
        }
    )
}