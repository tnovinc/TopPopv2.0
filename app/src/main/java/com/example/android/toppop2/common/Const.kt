package com.example.android.toppop2.common

class Const {
    class Networking {
        companion object {
            const val BASE_URL =  "https://api.deezer.com/"
            const val GET_CHART_API = "chart"
            const val GET_ALBUM_API = "album/{id}"
        }
    }
    class Database {
        companion object {
            const val DB_NAME = "toppop"
        }
    }
}