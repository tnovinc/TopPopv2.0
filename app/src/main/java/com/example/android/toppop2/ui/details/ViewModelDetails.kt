package com.example.android.toppop2.ui.details

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import com.example.android.toppop2.common.BaseViewModel
import com.example.android.toppop2.data.models.ui.Album
import com.example.android.toppop2.data.repository.Repository
import kotlinx.coroutines.*

class ViewModelDetails(val albumId: Int, val repository: Repository, application: Application): BaseViewModel(application){

    private var _album = MutableLiveData<Album>()
    val album: LiveData<Album>
        get() = _album

    init{
        viewModelScope.launch {
            _album.value = repository.getAlbum(albumId)
        }
    }

}