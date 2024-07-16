package com.health.openin.view

import android.graphics.Paint.Align
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.health.openin.R
import com.health.openin.ui.theme.BlueColor
import com.health.openin.ui.theme.BodyColor
import com.health.openin.view.components.AppBody
import com.health.openin.view.components.AppHeader

@Composable
fun DashBoardScreen(
    navController: NavHostController
) {
    Surface (
        modifier = Modifier
            .fillMaxSize(),
        color = BlueColor
    ){
        Column {
            AppHeader()
            AppBody(name = "Rohan Jha")
        }
    }
}




@Preview
@Composable
fun PreviewDashBoardScreen() {
    val navController = rememberNavController()
    DashBoardScreen(navController)
}