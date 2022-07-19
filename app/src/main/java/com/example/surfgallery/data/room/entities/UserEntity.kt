package com.example.surfgallery.data.room.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.surfgallery.data.models.User


@Entity(
    tableName = "Users"
)
data class UserEntity(
    val about: String,
    val avatar: String,
    val city: String,
    val email: String,
    val firstName: String,
    @PrimaryKey(autoGenerate = false) val id: String,
    @ColumnInfo(name = "lastName") val lastName: String,
    val phone: String
) {

    fun toUser(): User = User(
        about, avatar, city, email, firstName, id, lastName, phone
    )
}