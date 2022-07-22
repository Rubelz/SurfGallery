package com.example.surfgallery.ui.profile

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.surfgallery.data.models.User
import kotlinx.coroutines.launch

class ProfileViewModel : ViewModel() {

    private var _userDetails = MutableLiveData<User?>()
    val userResult: LiveData<User?> = _userDetails

    suspend fun getUser() {

    }

}