package com.example.android.toppop2.ui.details

import android.app.Application
import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.example.android.toppop2.common.BaseViewModel
import com.example.android.toppop2.data.models.ui.Album
import com.example.android.toppop2.data.repository.Repository
import kotlinx.coroutines.*

class ViewModelDetails
    @ViewModelInject
    constructor(
        application: Application,
        val repository: Repository
        //val albumId: Int
    ): BaseViewModel(application){

    private var _album = MutableLiveData<Album>()
    val album: LiveData<Album>
        get() = _album

    init{
        viewModelScope.launch {
            _album.value = repository.getAlbum(0)
        }
    }

}