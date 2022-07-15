package com.example.surfgallery.data.api

import com.example.surfgallery.data.models.Picture
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.POST
import java.util.concurrent.Flow

interface PictureService {

    @POST("picture")
    suspend fun getPictures(@Header("Authorization") token: String?): Response<List<Picture>>
}