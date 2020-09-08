package com.example.android.toppop2.retrofit.models

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Chart(val tracks: ChartTracks)

@JsonClass(generateAdapter = true)
data class ChartTracks(val data: List<ChartTrack>)

@JsonClass(generateAdapter = true)
data class ChartTrack(
        val id: Int,
        val title: String,
        val duration: Int,
        val position: Int,
        val artist: ChartArtist,
        val album: ChartAlbum)

@JsonClass(generateAdapter = true)
data class ChartArtist(
        val id: Int,
        val name: String,
        val picture: String)

@JsonClass(generateAdapter = true)
data class ChartAlbum(
        val id: Int,
        val title: String,
        val cover: String)

fun Chart.asListOfTracks() : List<Track>{
    return tracks.data.map {
        Track(
            id = it.id,
            title = it.title,
            duration = it.duration,
            position = it.position,
            artistName = it.artist.name,
            artistPicture = it.artist.picture,
            albumId = it.album.id,
            albumTitle = it.album.title,
            albumCover = it.album.cover
        )
    }
}