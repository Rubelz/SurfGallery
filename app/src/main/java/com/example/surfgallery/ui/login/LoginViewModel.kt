package com.example.surfgallery.ui.login

import android.se.omapi.Session
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.surfgallery.data.Retrofit
import com.example.surfgallery.data.api.UserService
import com.example.surfgallery.data.requests.LoginRequest
import com.example.surfgallery.utils.SessionManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class LoginViewModel : ViewModel() {

    private var _loginResult = MutableLiveData<String>()
    val loginResult = _loginResult

    suspend fun login(phone: String, password: String) {
        viewModelScope.launch {
            val response = Retrofit.getInstance().create(UserService::class.java)
            val result = response.login(LoginRequest(phone, password)).body()

            if (result?.token != null) {
                _loginResult.postValue(result?.token)
            } else {
                // TODO: Do something instead
            }

        }
    }
}