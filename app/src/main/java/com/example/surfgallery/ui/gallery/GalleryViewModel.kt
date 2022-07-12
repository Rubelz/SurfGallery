package com.example.surfgallery.ui.gallery

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.surfgallery.data.Retrofit
import com.example.surfgallery.data.api.PictureService
import com.example.surfgallery.data.models.Picture
import kotlinx.coroutines.launch

class GalleryViewModel : ViewModel() {
    private var _image = MutableLiveData<List<Picture>>()
    val image = _image

    suspend fun getPicture(token: String?) {
        viewModelScope.launch {
            val response = Retrofit.getInstance().create(PictureService::class.java)
            val result = response.getPictures(token)
            if (result.body() != null) {
                val pictures = result.body()
                _image.postValue(pictures)
            } else {

                // TODO: Show an Error
            }

        }
    }
}