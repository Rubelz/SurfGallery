package com.example.surfgallery.data.room

import com.example.surfgallery.data.models.User
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class RoomUsersRepository(private val usersDao: UsersDao) {

    private fun getUser(): Flow<User?> {

        return usersDao.getUser().map { userEntity ->
            userEntity?.toUser()
        }
    }
}