package com.example.surfgallery.data.api

import com.example.surfgallery.data.models.AuthInfo
import com.example.surfgallery.data.models.LoginRequest
import com.example.surfgallery.data.models.User
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface UserService {

    @POST("/auth/login")
    suspend fun login(@Body login: LoginRequest): Response<AuthInfo>
}