package com.example.android.toppop2.ui.chart

import android.app.Application
import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.example.android.toppop2.common.BaseViewModel
import com.example.android.toppop2.common.Const
import com.example.android.toppop2.data.repository.Repository
import kotlinx.coroutines.launch

class ViewModelChart
    @ViewModelInject
    constructor(
        application: Application,
        val repository: Repository,
        @Assisted private val savedStateHandle: SavedStateHandle
    ): BaseViewModel(application){

    private val _itemClicked = MutableLiveData<Int?>()
    val itemClicked: LiveData<Int?>
        get() = _itemClicked

    private val _sortType = MutableLiveData<SortType>()
    val sortType: LiveData<SortType>
        get() = _sortType

    init {
        viewModelScope.launch {
            repository.refresh()
        }
        _itemClicked.value = null
        _sortType.value = SortType.RANKING
    }

    val chart = repository.getChart()

    fun onItemClicked(albumId: Int){
        _itemClicked.value = albumId
    }

    fun onItemClickNavigateComplete(){
        _itemClicked.value = null
    }

    fun sortByRanking(){
        _sortType.value = SortType.RANKING
    }

    fun sortByDurationAscending(){
        _sortType.value = SortType.DURATION_ASC
    }

    fun sortByDurationDescending(){
        _sortType.value = SortType.DURATION_DESC
    }
}