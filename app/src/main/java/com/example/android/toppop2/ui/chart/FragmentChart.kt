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
import com.example.android.toppop2.data.repository.Repository
import com.example.android.toppop2.data.room.TopPopDatabase
import com.example.android.toppop2.data.room.getDatabase
import com.example.android.toppop2.databinding.FragmentChartLayoutBinding
import com.example.android.toppop2.ui.adapters.chart.ChartRecyclerViewAdapter
import com.example.android.toppop2.ui.adapters.chart.ItemClickListener

class FragmentChart : Fragment(){

    private val viewModel: ViewModelChart by lazy {
        val database = getDatabase(requireContext().applicationContext)
        val repository = Repository(database)
        ViewModelProvider(this, ViewModelChartFactory(requireActivity().application, repository)).get(ViewModelChart::class.java)
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

        binding.recyclerView.setHasFixedSize(true)
        val layoutManager = LinearLayoutManager(context)
        val adapter = ChartRecyclerViewAdapter(ItemClickListener {
            viewModel.onItemClicked(it)
        })
        binding.recyclerView.layoutManager = layoutManager
        binding.recyclerView.adapter = adapter

        viewModel.chart.observe(viewLifecycleOwner, Observer {
            it?.let {
                adapter.data = it
            }
        })

        viewModel.itemClicked.observe(viewLifecycleOwner, Observer {
            it?.let {
                findNavController().navigate(FragmentChartDirections.actionFragmentChartToFragmentDetails(it))
                viewModel.onItemClickNavigateComplete()
            }
        })

        return binding.root
    }
}