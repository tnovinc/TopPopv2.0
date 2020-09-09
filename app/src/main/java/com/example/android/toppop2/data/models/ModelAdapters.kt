package com.example.android.toppop2.data.models

import com.example.android.toppop2.data.models.database.AlbumTracks
import com.example.android.toppop2.data.models.database.Albums
import com.example.android.toppop2.data.models.database.Tracks
import com.example.android.toppop2.data.models.networking.album.AlbumDTO
import com.example.android.toppop2.data.models.networking.chart.ChartDTO
import com.example.android.toppop2.data.models.ui.Album
import com.example.android.toppop2.data.models.ui.AlbumTrack
import com.example.android.toppop2.data.models.ui.ChartTrack

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

fun Albums.asAlbumModel(tracks: List<AlbumTracks>): Album {
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

//DTO u modele za pohranu u bazu
fun AlbumDTO.asDatabaseEntity(): Albums {
    return Albums(
        id = id,
        title = title,
        cover = cover,
        artistName = artist.name
    )
}

fun AlbumDTO.tracksAsDatabaseEntities(): List<AlbumTracks>{
    return tracks.data.map{
        AlbumTracks(
            id = it.id,
            title = it.title,
            duration = it.duration,
            albumId = id
        )
    }
}

//DTO u model za pohranu u bazu
fun ChartDTO.asDatabaseEntities(): List<Tracks> {
    return tracks.data.map {
        Tracks(
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