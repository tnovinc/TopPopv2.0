package com.example.android.toppop2.repository

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.example.android.toppop2.models.Album
import com.example.android.toppop2.models.ChartTrack
import com.example.android.toppop2.retrofit.RetrofitClient
import com.example.android.toppop2.retrofit.dto.asDatabaseEntities
import com.example.android.toppop2.retrofit.dto.asDatabaseEntity
import com.example.android.toppop2.retrofit.dto.tracksAsDatabaseEntities
import com.example.android.toppop2.room.asAlbumModel
import com.example.android.toppop2.room.asChartTrackList
import com.example.android.toppop2.room.getDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class Repository(application: Application){

    private val database = getDatabase(application)

    suspend fun refresh(){
        withContext(Dispatchers.IO){
            val chartTracks = RetrofitClient.client.getChart().await()
            database.chartDao.insertChartTracks(chartTracks.asDatabaseEntities())
            chartTracks.tracks.data.forEach {
                val album = RetrofitClient.client.getAlbum(it.album.id).await()
                database.albumDao.insertAlbum(album.asDatabaseEntity())
                database.albumDao.insertAlbumTracks(album.tracksAsDatabaseEntities())
            }
        }
    }

    fun getChart(): LiveData<List<ChartTrack>> {
        return Transformations.map(database.chartDao.getChartTracks()){
            it.asChartTrackList()
        }
    }

    fun getAlbum(albumId: Int): Album{
        val albumTracks = database.albumDao.getAlbumTracks(albumId)
        return database.albumDao.getAlbum(albumId).asAlbumModel(albumTracks)
    }
}