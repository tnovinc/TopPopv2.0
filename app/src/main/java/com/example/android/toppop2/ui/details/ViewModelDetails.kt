package com.example.android.toppop2.ui.details

import android.app.Application
import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import com.example.android.toppop2.common.BaseViewModel
import com.example.android.toppop2.data.models.ui.Album
import com.example.android.toppop2.data.repository.Repository
import kotlinx.coroutines.launch

class ViewModelDetails
    @ViewModelInject
    constructor(
        application: Application,
        val repository: Repository,
        @Assisted savedStateHandle: SavedStateHandle
    ): BaseViewModel(application){

    private var _album = MutableLiveData<Album>()
    val album: LiveData<Album>
        get() = _album

    private val albumId = savedStateHandle.get<Int>("albumId")

    init{
        viewModelScope.launch {
            _album.value = albumId?.let { repository.getAlbum(it) }
        }
    }

}