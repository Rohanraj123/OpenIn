package com.health.openin.view.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.BottomNavigation
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.health.openin.R

@Composable
fun CustomBottomNavigationBarWithCanvas(
    navController: NavHostController,
    onFabClick: () -> Unit
) {

    val configuration = LocalConfiguration.current
    val screenWidthDp = configuration.screenWidthDp

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp) // Adjust height as needed
            .background(Color.Transparent)
    ) {
        Canvas(
            modifier = Modifier
                .fillMaxSize()
                .align(Alignment.BottomCenter)
        ) {
            val width = size.width
            val height = size.height

            // Draw the background shape of the bottom navigation bar
            drawRoundRect(
                color = Color.White,
                topLeft = Offset(0f, 0f),
                size = Size(width, height),
                cornerRadius = CornerRadius(16.dp.toPx(), 16.dp.toPx())
            )

            // Draw a curve to make space for the FAB
            drawRoundRect(
                color = Color.White,
                topLeft = Offset(0f, height - 60.dp.toPx()),
                size = Size(width, 60.dp.toPx()),
                cornerRadius = CornerRadius(16.dp.toPx(), 16.dp.toPx())
            )
        }

        // Floating Action Button
        FloatingActionButton(
            onClick = onFabClick,
            backgroundColor = Color.Blue,
            contentColor = Color.White,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .offset(y = (-30).dp) // Adjust to overlap the navigation bar
                .size(60.dp)
        ) {
            Icon(imageVector = Icons.Default.Add, contentDescription = "Add")
        }

        // Bottom Navigation Items
        Row(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            // Left Side Items
            Row (
                modifier = Modifier.width(screenWidthDp.dp/2),
                horizontalArrangement = Arrangement.SpaceEvenly
            ){

                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.link),
                        contentDescription = null,
                        modifier = Modifier.size(20.dp)
                            .clickable {
                                navController.navigate("links_screen"){
                                    popUpTo("dashboard_screen") {inclusive =false}
                                }
                            }
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(text = "Links")
                }

                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.magazine),
                        contentDescription = null,
                        modifier = Modifier.size(20.dp)
                            .clickable {
                                navController.navigate("courses_screen") {
                                    popUpTo("dashboard_screen") {inclusive =false}
                                }
                            }
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(text = "Courses")
                }
            }

            Row (
                modifier = Modifier.width(screenWidthDp.dp/2),
                horizontalArrangement = Arrangement.SpaceEvenly
            ){
                Column (
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                    Image(
                        painter = painterResource(id = R.drawable.campaigns),
                        contentDescription = null,
                        modifier = Modifier.size(20.dp)
                            .clickable {
                                navController.navigate("campaigns_screen") {
                                    popUpTo("dashboard_screen") {inclusive =false}
                                }
                            }
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(text = "Campaigns")
                }

                Column (
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                    Image(
                        painter = painterResource(id = R.drawable.profile),
                        contentDescription = null,
                        modifier = Modifier.size(20.dp)
                            .clickable {
                                navController.navigate("profile_screen") {
                                    popUpTo("dashboard_screen") {inclusive =false}
                                }
                            }
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(text = "Profile")
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewBottomnavbar() {
    val navCnltr = rememberNavController()
    CustomBottomNavigationBarWithCanvas(navController = navCnltr) {

    }
}