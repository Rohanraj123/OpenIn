package com.health.openin.view

import android.graphics.Paint.Align
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalWindowInfo
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.health.openin.R
import com.health.openin.data.models.TopLink
import com.health.openin.ui.theme.BlueColor
import com.health.openin.ui.theme.BodyColor
import com.health.openin.util.VerticalListCardData
import com.health.openin.view.components.AppBody
import com.health.openin.view.components.AppHeader
import com.health.openin.view.components.CustomCard
import com.health.openin.viewmodel.DashboardScreenViewModel

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun DashBoardScreen(
    navController: NavHostController,
    dashboardScreenViewModel: DashboardScreenViewModel
) {
    val apiData by dashboardScreenViewModel.apiData.collectAsState()


    Surface(
        modifier = Modifier
            .fillMaxSize(),
        color = BlueColor
    ) {
        Column {
            // App header
            AppHeader()

            // Scrollable column for the app body
            AppBody(name = "Rohan Jha", dashboardScreenViewModel)
        }
    }
}
