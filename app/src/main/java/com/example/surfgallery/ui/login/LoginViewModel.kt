package com.example.surfgallery.ui.login

import android.se.omapi.Session
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.surfgallery.data.Retrofit
import com.example.surfgallery.data.api.UserService
import com.example.surfgallery.data.models.User
import com.example.surfgallery.data.requests.LoginRequest
import com.example.surfgallery.data.room.UserReciever
import com.example.surfgallery.utils.SessionManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class LoginViewModel : ViewModel() {

    private var _tokenResult = MutableLiveData<String>()
    private var _userResult = MutableLiveData<User>()
    val loginResult: LiveData<String> = _tokenResult
    val userResult: LiveData<User> = _userResult

    suspend fun login(sessionManager: SessionManager) {
        viewModelScope.launch {
            val token = sessionManager.fetchToken()
            if (!token.isNullOrBlank()) {
                _tokenResult.postValue(token)
            } else {
                sessionManager.removeToken()
            }

        }

    }

    suspend fun login(phone: String, password: String) {
        viewModelScope.launch {
            val response = Retrofit.getInstance().create(UserService::class.java)
            val result = response.login(LoginRequest(phone, password)).body()
            if (result?.token != null && result?.userInfo != null) {
                _userResult.postValue(result.userInfo)
                _tokenResult.postValue(result.token)

            } else {
                // TODO: Do something instead
            }

        }
    }



    override fun onCleared() {
        super.onCleared()
    }
}