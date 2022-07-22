package com.example.surfgallery.data.room.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.surfgallery.data.models.User

@Dao
interface UserDao {

    @Query("Select * from users")
    fun getUser(): LiveData<User>

    @Insert (onConflict = OnConflictStrategy.IGNORE)
    fun addUser(user: User?)

}