package com.example.surfgallery.data.room

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.surfgallery.data.models.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserViewModel(app: Application) : AndroidViewModel(app) {

    private var _user = MutableLiveData<User>()
    var user: LiveData<User> = _user
    private val repository: UserRepository

    init {
        val userDao = SurfDb.getDb(app).userDao()
        repository = UserRepository(userDao)
        //  _user = repository.readUser as MutableLiveData<User>
//        if(repository.readUser != null) {
//        user = repository.readUser
//        }
    }

    fun addUser(user: User?) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addUser(user)
        }
    }

    fun getUser(): User? {
        user = repository.readUser

        return user.value

    }

}