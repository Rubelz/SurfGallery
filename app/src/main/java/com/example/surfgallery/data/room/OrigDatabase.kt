package com.example.surfgallery.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.surfgallery.data.room.entities.UserEntity

@Database(
    version = 1,
    entities = [UserEntity::class]
)
abstract class OrigDatabase: RoomDatabase() {

    abstract fun getUsersDao(): UsersDao
}