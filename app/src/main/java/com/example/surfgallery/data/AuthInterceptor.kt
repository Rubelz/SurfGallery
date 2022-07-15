package com.example.surfgallery.data

import android.content.Context
import com.example.surfgallery.utils.SessionManager
import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor(context: Context) : Interceptor {

    private val sessionManager = SessionManager(context)

    override fun intercept(chain: Interceptor.Chain): Response {
        val requestBuilder = chain.request().newBuilder()

        sessionManager.fetchToken()?.let { token ->
            requestBuilder.addHeader("Authorization", "Token $token")

        }
        return chain.proceed(requestBuilder.build())
    }

}