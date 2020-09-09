package com.example.android.toppop2.retrofit.dto

import com.example.android.toppop2.models.Album
import com.example.android.toppop2.models.AlbumTrack
import com.example.android.toppop2.room.AlbumTracks
import com.example.android.toppop2.room.Albums
import com.example.android.toppop2.room.Tracks
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

////DTO u model za prikazivanje
//fun AlbumDTO.asAlbum(): Album {
//    return Album(
//        id = id,
//        title = title,
//        cover = cover,
//        artistName = artist.name,
//        tracks = tracks.data.map {
//            AlbumTrack(
//                id = it.id,
//                title = it.title,
//                duration = it.duration
//            )
//        }
//    )
//}

//DTO u modele za pohranu u bazu
fun AlbumDTO.asDatabaseEntity(): Albums{
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