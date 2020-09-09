package com.example.android.toppop2.room

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.android.toppop2.models.Album
import com.example.android.toppop2.models.AlbumTrack
import com.example.android.toppop2.models.ChartTrack

@Entity
data class Tracks(
    @PrimaryKey
    val id: Int,
    val title: String,
    val duration: Int,
    val position: Int,
    val artistName: String,
    val artistPicture: String,
    val albumId: Int
)

@Entity
data class Albums(
    @PrimaryKey
    val id: Int,
    val title: String,
    val cover: String,
    val artistName: String
)

@Entity
data class AlbumTracks(
    @PrimaryKey
    val id: Int,
    val title: String,
    val duration: Int,
    val albumId: Int
)

fun List<Tracks>.asChartTrackList(): List<ChartTrack>{
    return map{
        ChartTrack(
            id = it.id,
            title = it.title,
            duration = it.duration,
            position = it.position,
            artistName = it.artistName,
            artistPicture = it.artistPicture,
            albumId = it.albumId
        )
    }
}

fun Albums.asAlbumModel(tracks: List<AlbumTracks>): Album{
    return Album(
        id = id,
        title = title,
        cover = cover,
        artistName = artistName,
        tracks = tracks.map {
            AlbumTrack(
                id = it.id,
                title = it.title,
                duration = it.duration
            )
        }
    )
}