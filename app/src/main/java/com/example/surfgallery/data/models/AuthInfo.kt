package com.example.surfgallery.data.models


import com.google.gson.annotations.SerializedName

data class AuthInfo(
    @SerializedName("token") val token: String,
    @SerializedName("user_info") val userInfo: String
)