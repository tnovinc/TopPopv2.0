package com.example.android.toppop2.data.models.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Albums(
    @PrimaryKey
    val id: Int,
    val title: String,
    val cover: String,
    val artistName: String
)