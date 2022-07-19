package com.example.surfgallery.data.api

import com.example.surfgallery.data.response.AuthInfo
import com.example.surfgallery.data.requests.LoginRequest
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface UserService {

    @POST("auth/login")
    suspend fun login(@Body login: LoginRequest): Response<AuthInfo>
}