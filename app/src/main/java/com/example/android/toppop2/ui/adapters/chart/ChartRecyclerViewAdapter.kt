package com.example.android.toppop2.ui.adapters.chart

import android.net.Uri
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.android.toppop2.R
import com.example.android.toppop2.data.models.ui.ChartTrack
import kotlinx.android.synthetic.main.chart_recycler_item.view.*
import java.util.*

class ChartRecyclerViewAdapter(val onClickListener: ItemClickListener): RecyclerView.Adapter<ChartViewHolder>(){

    var data = listOf<ChartTrack>()
        set(value){
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChartViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.chart_recycler_item, parent, false) as CardView
        return ChartViewHolder(
            view
        )
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ChartViewHolder, position: Int) {
        holder.cardView.trackPositionTextView.text = data[position].position.toString()
        holder.cardView.artistImageView.setImageURI(Uri.parse(data[position].artistPicture))
        holder.cardView.trackTitleTextView.text = data[position].title
        holder.cardView.artistNameTextView.text = data[position].artistName
        holder.cardView.trackDurationTextView.text = String.format(Locale.ENGLISH,"%02d:%02d", (data[position].duration/60), (data[position].duration%60))
        holder.cardView.cardView.setOnClickListener{
            onClickListener.onClick(data[position])
        }
    }
}