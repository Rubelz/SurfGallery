package com.example.surfgallery.data.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.surfgallery.data.models.User
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {

    @Query("Select * From users")
    fun getUser(): Flow<User>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addUser(user: User)

}