package com.health.openin.view.Navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.health.openin.view.CampaignsScreen
import com.health.openin.view.CoursesScreen
import com.health.openin.view.DashBoardScreen
import com.health.openin.view.LinksScreen
import com.health.openin.view.ProfileScreen
import com.health.openin.view.components.CustomBottomNavigationBarWithCanvas
import androidx.navigation.compose.rememberNavController as rememberNavController1

@Composable
fun MyApp(navController: NavHostController) {

    Scaffold(
        bottomBar = {
            CustomBottomNavigationBarWithCanvas(
                navController = navController,
                onFabClick = { /* Handle FAB Click */ }
            )
        },
        content = { innerPadding ->
            NavHost(
                navController = navController,
                startDestination = "dashboard_screen",
                Modifier.padding(innerPadding)
            ) {
                composable("dashboard_screen") { DashBoardScreen(navController) }
                composable("profile_screen") { ProfileScreen() }
                composable("campaigns_screen") { CampaignsScreen() }
                composable("courses_screen") { CoursesScreen() }
                composable("links_screen") { LinksScreen() }
            }
        }
    )
}
