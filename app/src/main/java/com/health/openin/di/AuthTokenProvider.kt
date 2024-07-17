package com.health.openin.di

import javax.inject.Inject

class AuthTokenProvider @Inject constructor() {
    fun getAuthToken(): String {
        return "Your bearer token stored in shared preferences"
    }
}