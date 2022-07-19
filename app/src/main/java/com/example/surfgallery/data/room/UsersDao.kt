package com.example.surfgallery.data.room

import androidx.room.Dao
import androidx.room.Query
import com.example.surfgallery.data.room.entities.UserEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface UsersDao{

    @Query("SELECT * FROM Users")
    fun getUser(): Flow<UserEntity?>
}