package com.example.surfgallery.data.room

import androidx.room.Database
import com.example.surfgallery.data.models.User

@Database(
    entities = [User::class],
    version = 1
)
abstract class SurfRoomDb {

    abstract fun userDao(): UserDao


}