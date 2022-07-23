package com.example.surfgallery.data.room

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.surfgallery.data.models.User
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class UserViewModel(private val userDao: UserDao) : ViewModel() {


//    private var _user = MutableLiveData<kotlinx.coroutines.flow.Flow<User>>()
//    val user = _user
//
//    suspend fun getUser() {
//        viewModelScope.launch(IO) {
//
//            val userInfo = userDao.getUser()
//            if (userInfo != null) {
//                _user.postValue(userInfo)
//            }
//        }
//    }

    suspend fun getUser(): Flow<User> = userDao.getUser()

    suspend fun addUser(user: User) {
        viewModelScope.launch {
            userDao.addUser(user)
        }
    }
}
//
//class RoomVMFactory(private val userDao: UserDao) : ViewModelProvider.Factory {
//
//    override fun <T : ViewModel> create(modelClass: Class<T>): T {
//        if (modelClass.isAssignableFrom(UserViewModel::class.java)) {
//            @Suppress("UNCHECKED_CAST")
//            return UserViewModel(userDao) as T
//        }
//        throw IllegalStateException("Unknown ViewModel class")
//    }
//}