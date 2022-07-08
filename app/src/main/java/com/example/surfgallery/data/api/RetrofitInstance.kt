package com.example.surfgallery.data.api

import com.example.surfgallery.utils.Consts.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val photoApi: PhotoService by lazy {
        retrofit.create(PhotoService::class.java)
    }

    val userApi: UserService by lazy {
        retrofit.create(UserService::class.java)
    }
}