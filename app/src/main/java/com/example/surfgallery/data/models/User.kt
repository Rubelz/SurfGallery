package com.example.surfgallery.data.models


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(
    tableName = "users"
)
data class User(
    @SerializedName("about") val about: String,
    @SerializedName("avatar") val avatar: String,
    @SerializedName("city") val city: String,
    @SerializedName("email") val email: String,
    @SerializedName("firstName") val firstName: String,
    @SerializedName("id") @PrimaryKey(autoGenerate = false) val id: String,
    @SerializedName("lastName") val lastName: String,
    @SerializedName("phone") val phone: String
)