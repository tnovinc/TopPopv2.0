package com.example.android.toppop2.retrofit

import com.example.android.toppop2.retrofit.models.AlbumDTO
import com.example.android.toppop2.retrofit.models.Chart
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Path

//service za dohvacanje top liste i albuma
interface RetrofitService{

    @GET("chart")
    fun getChart(): Deferred<Chart>

    @GET("/album/{id}")
    fun getAlbum(@Path("id") albumId: Int): Deferred<AlbumDTO>
}