package com.example.android.toppop2.ui.chart

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.android.toppop2.data.repository.Repository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch

class ViewModelChart(application: Application): AndroidViewModel(application){

    private val viewModelJob = SupervisorJob()
    private val viewModelScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    private val repository = Repository(application)

    init {
        viewModelScope.launch {
            repository.refresh()
        }
    }

    val chart = repository.getChart()

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