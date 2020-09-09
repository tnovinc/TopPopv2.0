package com.example.android.toppop2.chart

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.android.toppop2.R
import com.example.android.toppop2.databinding.FragmentChartLayoutBinding

class FragmentChart : Fragment(){

    private val viewModel: ViewModelChart by lazy {
        ViewModelProvider(this, ViewModelChart.Factory(requireActivity().application)).get(ViewModelChart::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding: FragmentChartLayoutBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_chart_layout,
            container,
            false
        )

        viewModel.chart.observe(viewLifecycleOwner, Observer {
            it?.let {
                binding.testText.text = it[0].title
            }
        })

        return binding.root
    }
}