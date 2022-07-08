package com.example.surfgallery.data.models


import com.google.gson.annotations.SerializedName

data class Error(
    @SerializedName("code") val code: String,
    @SerializedName("message") val message: String
)