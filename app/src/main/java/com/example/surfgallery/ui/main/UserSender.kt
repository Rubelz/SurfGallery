package com.example.surfgallery.ui.main

import com.example.surfgallery.data.models.User

interface UserSender {

    fun sendUser(user: User?)
}