package com.example.surfgallery.ui.profile

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.surfgallery.data.models.User

class ProfileViewModel : ViewModel() {

    private var _userResult = MutableLiveData<User>()
    val userResult = _userResult

    suspend fun getUser() {

    }
}