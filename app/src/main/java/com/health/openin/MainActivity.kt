package com.health.openin

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import com.health.openin.util.TokenManager
import com.health.openin.view.Navigation.Navigation
import com.health.openin.viewmodel.DashboardScreenViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Log.d("MainActivity", "Starting MainActivity.kt file")
            TokenManager.initialize(this)
            TokenManager.setToken(stringResource(id = R.string.bearer_token))
            Log.d("MainActivity", "Initialised token")
            TokenManager.getToken()
            Log.d("MainActivity", "Bearer Token : ${TokenManager.getToken()}")

            val dashboardScreenViewModel = hiltViewModel<DashboardScreenViewModel>()
            val navController = rememberNavController()
            Navigation(
                navController,
                dashboardScreenViewModel
            )
        }
    }

}

