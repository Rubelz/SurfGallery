package com.example.surfgallery.data.room

import android.util.Log
import com.example.surfgallery.data.models.User
import com.example.surfgallery.data.room.dao.UserDao

class UserRepository(private val userDao: UserDao) {

    val readUser = userDao.getUser()

    suspend fun addUser(user: User?) {
        userDao.addUser(user)
    }

}