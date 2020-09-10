package com.example.android.toppop2.ui.adapters.chart

import com.example.android.toppop2.data.models.ui.ChartTrack

class ItemClickListener(val clickListener: (albumId: Int) -> Unit) {

    fun onClick(track: ChartTrack) = clickListener(track.albumId)

}