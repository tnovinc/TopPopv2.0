package com.example.android.toppop2.data.retrofit

import com.example.android.toppop2.common.Const
import com.example.android.toppop2.data.models.networking.album.AlbumDTO
import com.example.android.toppop2.data.models.networking.chart.ChartDTO
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Path

//service za dohvacanje top liste i albuma
interface RetrofitService{

    @GET(Const.Networking.GET_CHART_API)
    fun getChart(): Deferred<ChartDTO>

    @GET(Const.Networking.GET_ALBUM_API)
    fun getAlbum(@Path("id") albumId: Int): Deferred<AlbumDTO>
}