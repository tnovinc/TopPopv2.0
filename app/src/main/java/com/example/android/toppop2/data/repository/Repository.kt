package com.example.android.toppop2.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.example.android.toppop2.data.models.*
import com.example.android.toppop2.data.models.ui.Album
import com.example.android.toppop2.data.models.ui.ChartTrack
import com.example.android.toppop2.data.retrofit.RetrofitService
import com.example.android.toppop2.data.room.TopPopDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class Repository
    @Inject
    constructor(val retrofit: RetrofitService, val database: TopPopDatabase){

    suspend fun refresh(){
        withContext(Dispatchers.IO){
            database.chartDao.deleteAll()
            val chartTracks = retrofit.getChart().await()
            database.chartDao.insertChartTracks(chartTracks.asDatabaseEntities())
            chartTracks.tracks.data.forEach {
                val album = retrofit.getAlbum(it.album.id).await()
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

    suspend fun getAlbum(albumId: Int): Album {
        return withContext(Dispatchers.IO){
            return@withContext database.albumDao.getAlbum(albumId).asAlbumModel(database.albumDao.getAlbumTracks(albumId))
        }

    }
}