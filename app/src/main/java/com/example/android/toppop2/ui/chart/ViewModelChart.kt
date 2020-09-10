package com.example.android.toppop2.ui.chart

import android.app.Application
import androidx.lifecycle.*
import com.example.android.toppop2.data.repository.Repository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch

class ViewModelChart(application: Application): AndroidViewModel(application){

    private val viewModelJob = SupervisorJob()
    private val viewModelScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    private val repository = Repository(application)

    private val _itemClicked = MutableLiveData<Int>()
    val itemClicked: LiveData<Int>
        get() = _itemClicked

    init {
        viewModelScope.launch {
            repository.refresh()
        }
        _itemClicked.value = -1
    }

    val chart = repository.getChart()

    fun onItemClicked(albumId: Int){
        _itemClicked.value = albumId
    }

    fun onItemClickNavigateComplete(){
        _itemClicked.value = -1
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }

    class Factory(val app: Application) : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(ViewModelChart::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return ViewModelChart(app) as T
            }
            throw IllegalArgumentException("Unable to construct viewmodel")
        }
    }
}