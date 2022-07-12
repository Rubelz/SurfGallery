package com.example.surfgallery.utils


import android.content.Context
import android.content.SharedPreferences
import com.example.surfgallery.utils.Consts
import com.example.surfgallery.utils.Consts.APP_PREF
import com.example.surfgallery.utils.Consts.PREFS_KEY_RETROFIT_1

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