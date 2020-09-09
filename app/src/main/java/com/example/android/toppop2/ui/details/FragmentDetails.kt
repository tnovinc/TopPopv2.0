package com.example.android.toppop2.ui.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
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

        return binding.root
    }
}