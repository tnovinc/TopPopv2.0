package com.example.android.toppop2.ui.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.android.toppop2.R
import com.example.android.toppop2.databinding.FragmentDetailsLayoutBinding

class FragmentDetails : Fragment(){

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

        val albumId = FragmentDetailsArgs.fromBundle(arguments!!).albumId

        val viewModel = ViewModelProvider(this, ViewModelDetailsFactory(albumId, requireActivity().application)).get(ViewModelDetails::class.java)

        viewModel.album.observe(viewLifecycleOwner, Observer {
            it?.let {
                binding.albumTitleTextView.text = it.title
                binding.artistNameTextView.text = it.artistName
                Glide.with(this)
                    .load(it.cover)
                    .into(binding.albumCoverImageView)
            }
        })

        return binding.root
    }
}