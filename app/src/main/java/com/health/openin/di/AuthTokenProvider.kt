package com.health.openin.di

import android.content.Context
import android.media.session.MediaSession.Token
import android.util.Log
import com.health.openin.util.TokenManager
import javax.inject.Inject

class AuthTokenProvider @Inject constructor(
    private val context: Context
) {

    init {
        TokenManager.initialize(context)
    }

    fun getAuthToken(): String {
        return TokenManager.getToken() ?: ""
    }
}