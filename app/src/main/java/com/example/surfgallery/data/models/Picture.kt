package com.example.surfgallery.data.models


import com.google.gson.annotations.SerializedName

data class Picture(
    @SerializedName("content") val content: String,
    @SerializedName("id") val id: String,
    @SerializedName("photoUrl") val photoUrl: String,
    @SerializedName("publicationDate") val publicationDate: Long,
    @SerializedName("title") val title: String
)