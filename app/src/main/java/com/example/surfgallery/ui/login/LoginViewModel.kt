package com.example.surfgallery.ui.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.surfgallery.data.Repository
import com.example.surfgallery.data.models.LoginRequest
import com.example.surfgallery.data.models.User
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {

    private var _loginRequest = MutableLiveData<Boolean>()
    val loginRequest = _loginRequest

    suspend fun login(phone: String, pswd: String) {
        viewModelScope.launch {
            val login = LoginRequest(phone, pswd)
            val repository = Repository()
            val result = repository.loginUser(login)
            _loginRequest.postValue(result.isSuccessful)
        }
    }
}