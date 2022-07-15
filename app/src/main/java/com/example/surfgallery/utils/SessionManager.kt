package com.example.surfgallery.utils


import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import com.example.surfgallery.utils.Consts
import com.example.surfgallery.utils.Consts.APP_PREF
import com.example.surfgallery.utils.Consts.PREFS_KEY_RETROFIT_1
import com.example.surfgallery.utils.Consts.TOKEN_NOT_FOUND

class SessionManager(context: Context) {
    private var prefs: SharedPreferences =
        context.getSharedPreferences(APP_PREF, Context.MODE_PRIVATE)

    companion object {
        const val USER_TOKEN = "USER_T0KEN"
    }

    fun saveToken(token: String) {
        prefs.edit()
            .putString(USER_TOKEN, token)
            .apply()
    }

    fun fetchToken(): String? {
        return prefs.getString(USER_TOKEN, null)
    }

    fun removeToken() {
        prefs.edit()
            .putString(PREFS_KEY_RETROFIT_1, null)
            .apply()
    }

}