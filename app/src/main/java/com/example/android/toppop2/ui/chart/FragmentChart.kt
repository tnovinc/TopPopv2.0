package com.example.android.toppop2.ui.chart

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.android.toppop2.R
import com.example.android.toppop2.databinding.FragmentChartLayoutBinding
import com.example.android.toppop2.ui.adapters.chart.ChartRecyclerViewAdapter
import com.example.android.toppop2.ui.adapters.chart.ItemClickListener

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
                binding.recyclerView.setHasFixedSize(true)
                val layoutManager = LinearLayoutManager(context)
                val adapter = ChartRecyclerViewAdapter(ItemClickListener {
                    viewModel.onItemClicked(it)
                })
                binding.recyclerView.layoutManager = layoutManager
                adapter.data = it
                binding.recyclerView.adapter = adapter
            }
        })

        viewModel.itemClicked.observe(viewLifecycleOwner, Observer {
            if(it > -1) {
                findNavController().navigate(FragmentChartDirections.actionFragmentChartToFragmentDetails(it))
                viewModel.onItemClickNavigateComplete()
            }
        })

        return binding.root
    }
}