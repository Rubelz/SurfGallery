package com.example.surfgallery.data.models


import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("about") val about: String,
    @SerializedName("avatar") val avatar: String,
    @SerializedName("city") val city: String,
    @SerializedName("email") val email: String,
    @SerializedName("firstName") val firstName: String,
    @SerializedName("id") val id: String,
    @SerializedName("lastName") val lastName: String,
    @SerializedName("phone") val phone: String
)