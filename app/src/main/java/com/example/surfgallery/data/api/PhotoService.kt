package com.example.surfgallery.data.api

import com.example.surfgallery.data.models.Picture
import retrofit2.Response
import retrofit2.http.GET
import java.util.concurrent.Flow

interface PhotoService {

    @GET("/picture")
    suspend fun getPictures(): Response<List<Picture>>

    suspend fun get() {

    }
}