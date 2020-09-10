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

    init {
        viewModelScope.launch {
            repository.refresh()
        }
        _itemClicked.value = null
    }

    val chart = repository.getChart()

    fun onItemClicked(albumId: Int){
        _itemClicked.value = albumId
    }

    fun onItemClickNavigateComplete(){
        _itemClicked.value = null
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}