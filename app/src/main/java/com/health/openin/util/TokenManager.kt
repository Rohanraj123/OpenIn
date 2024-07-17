package com.health.openin.util

import android.content.Context
import android.content.SharedPreferences
import androidx.compose.ui.res.stringResource
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKeys
import com.health.openin.R

object TokenManager {

    private const val PREFS_NAME = "token_prefs"
    private const val TOKEN_KEY = "auth_token"

    private lateinit var sharedPrefs : SharedPreferences

    fun initialize(context: Context) {
        val masterKeyAlias = MasterKeys.getOrCreate(MasterKeys.AES256_GCM_SPEC)
        sharedPrefs = EncryptedSharedPreferences.create(
            PREFS_NAME,
            masterKeyAlias,
            context,
            EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
            EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
        )
    }

    // Store the token securely
    fun setToken(token: String) {
        sharedPrefs.edit().putString(TOKEN_KEY, token).apply()
    }

    // Retrieve the token securely
    fun getToken(): String? {
        return sharedPrefs.getString(TOKEN_KEY, null)
    }
    fun clearToken() {
        sharedPrefs.edit().remove(TOKEN_KEY).apply()
    }
}