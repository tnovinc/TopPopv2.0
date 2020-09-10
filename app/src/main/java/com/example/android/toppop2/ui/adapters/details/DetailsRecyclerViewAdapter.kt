package com.example.android.toppop2.ui.adapters.details

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.android.toppop2.R
import com.example.android.toppop2.data.models.ui.AlbumTrack
import kotlinx.android.synthetic.main.details_recycler_item.view.*
import java.util.*

class DetailsRecyclerViewAdapter: RecyclerView.Adapter<DetailsViewHolder>() {

    var data = listOf<AlbumTrack>()
        set(value){
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.details_recycler_item, parent, false) as CardView
        return DetailsViewHolder(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: DetailsViewHolder, position: Int) {
        holder.cardView.trackTitleTextView.text = data[position].title
        holder.cardView.durationTextView.text = String.format(Locale.ENGLISH,"%02d:%02d", (data[position].duration/60), (data[position].duration%60))
        holder.cardView.indexTextView.text = (position+1).toString()
    }
}