package com.example.android.toppop2.data.retrofit

import com.example.android.toppop2.common.Const
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

object RetrofitClient {

//    private val moshi = Moshi.Builder()
//        .add(KotlinJsonAdapterFactory())
//        .build()

    private val retrofit = Retrofit.Builder()
        .baseUrl(Const.Networking.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .build()

    val client = retrofit.create(RetrofitService::class.java)
}