package com.example.surfgallery.data

import com.example.surfgallery.data.api.RetrofitInstance
import com.example.surfgallery.data.models.LoginRequest
import retrofit2.Response

class Repository {

    suspend fun loginUser(login: LoginRequest): Response<LoginRequest> {
        return RetrofitInstance.userApi.login(login)
    }
}