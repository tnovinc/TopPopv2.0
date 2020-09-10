package com.example.android.toppop2.ui.chart

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.android.toppop2.data.repository.Repository

class ViewModelChartFactory(val app: Application, val repository: Repository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ViewModelChart::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return ViewModelChart(app, repository) as T
        }
        throw IllegalArgumentException("Unable to construct viewmodel")
    }
}