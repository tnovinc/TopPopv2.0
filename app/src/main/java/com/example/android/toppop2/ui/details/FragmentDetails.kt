package com.example.android.toppop2.ui.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.android.toppop2.R
import com.example.android.toppop2.data.repository.Repository
import com.example.android.toppop2.data.room.getDatabase
import com.example.android.toppop2.databinding.FragmentDetailsLayoutBinding
import com.example.android.toppop2.ui.adapters.details.DetailsRecyclerViewAdapter
import com.example.android.toppop2.ui.chart.ViewModelChart
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FragmentDetails : Fragment(){

    private val viewModel: ViewModelDetails by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentDetailsLayoutBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_details_layout,
            container,
            false
        )

        val layoutManager = LinearLayoutManager(context)
        val adapter = DetailsRecyclerViewAdapter()
        binding.albumTracksRecyclerView.setHasFixedSize(true)
        binding.albumTracksRecyclerView.layoutManager = layoutManager
        binding.albumTracksRecyclerView.adapter = adapter

        viewModel.album.observe(viewLifecycleOwner, Observer {
            it?.let {
                binding.albumTitleTextView.text = it.title
                binding.artistNameTextView.text = it.artistName
                Glide.with(this)
                    .load(it.cover)
                    .into(binding.albumCoverImageView)
                adapter.data = it.tracks
            }
        })

        return binding.root
    }
}