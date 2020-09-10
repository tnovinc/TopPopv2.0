package com.example.android.toppop2.ui.chart

import android.app.Application
import androidx.lifecycle.*
import com.example.android.toppop2.data.repository.Repository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch

class ViewModelChart(application: Application, val repository: Repository): AndroidViewModel(application){

    private val viewModelJob = SupervisorJob()
    private val viewModelScope = CoroutineScope(Dispatchers.Main + viewModelJob)

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

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}