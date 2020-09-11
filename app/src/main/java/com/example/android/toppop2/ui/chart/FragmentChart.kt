package com.example.android.toppop2.ui.chart

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.android.toppop2.R
import com.example.android.toppop2.common.Const
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

        viewModel.sortType.observe(viewLifecycleOwner, Observer {
            it?.let{
                when(it){
                    SortType.RANKING -> {
                        adapter.data = adapter.data.sortedBy {
                            it.position
                        }
                    }
                    SortType.DURATION_ASC -> {
                        adapter.data = adapter.data.sortedBy {
                            it.duration
                        }
                    }
                    SortType.DURATION_DESC -> {
                        adapter.data = adapter.data.sortedByDescending {
                            it.duration
                        }
                    }
                }
            }
        })

        setHasOptionsMenu(true)

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.sort_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.sortDurAsc -> viewModel.sortByDurationAscending()
            R.id.sortDurDesc -> viewModel.sortByDurationDescending()
            else -> viewModel.sortByRanking()
        }
        return true
    }
}