package com.example.surfgallery.data.models


import com.google.gson.annotations.SerializedName

data class LoginRequest(
    @SerializedName("phone") val phone: String,
    @SerializedName("password") val password: String
)