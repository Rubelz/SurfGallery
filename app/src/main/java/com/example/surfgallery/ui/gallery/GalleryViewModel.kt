package com.example.surfgallery.ui.gallery

import android.se.omapi.Session
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.surfgallery.data.Retrofit
import com.example.surfgallery.data.api.PictureService
import com.example.surfgallery.data.models.Picture
import com.example.surfgallery.utils.SessionManager
import kotlinx.coroutines.launch

class GalleryViewModel : ViewModel() {
    private var _image = MutableLiveData<List<Picture>>()
    val image = _image

    suspend fun getPicture(sessionManager: SessionManager) {
        viewModelScope.launch {
            val response = Retrofit.getInstance().create(PictureService::class.java)
            val result = response.getPictures(token = "Token ${sessionManager.fetchToken()}")

            Log.d("MyTag", result.body().toString())
            if (result.body().isNullOrEmpty()) {
                sessionManager.removeToken()
            } else {
                val pictures = result.body()
                _image.postValue(pictures)

                // TODO: Show an Error
            }

        }
    }
}