package com.example.android.toppop2.ui.details

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ViewModelDetailsFactory(
    private val albumId: Int,
    private val application: Application
) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ViewModelDetails::class.java)) {
            return ViewModelDetails(albumId, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
