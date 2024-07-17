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
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Stroke
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
import com.health.openin.ui.theme.BlueColor

@Composable
fun CustomBottomNavigationBarWithCanvas(
    navController: NavHostController,
    onFabClick: () -> Unit
) {

    val configuration = LocalConfiguration.current
    val screenWidthDp = configuration.screenWidthDp


    val fabSize = 50.dp
    val fabOffset = 30.dp
    val inflatedHeight = 60.dp
    val curveHeight = 20.dp

    // Background box
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
            .background(Color.White)
    ) {
        Canvas(
            modifier = Modifier
                .fillMaxSize()
                .align(Alignment.BottomCenter)
        ) {
            val width = size.width
            val height = size.height

            drawCustomShape(
                width = width,
                height = height,
                fabOffset = fabOffset.toPx(),
                inflatedHeight = inflatedHeight.toPx(),
                curveHeight = curveHeight.toPx()
            )
        }

        // Floating Action Button
        FloatingActionButton(
            onClick = onFabClick,
            backgroundColor = BlueColor,
            contentColor = Color.White,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .offset(y = (-30).dp) // Adjust to overlap the navigation bar
                .size(50.dp)
        ) {
            Icon(imageVector = Icons.Default.Add, contentDescription = "Add")
        }

        // Bottom Navigation Items
        Row(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth(),
            verticalAlignment = Alignment.Top,
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
                    Text(
                        text = "Links",
                        fontSize = 10.sp
                    )
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
                    Text(
                        text = "Courses",
                        fontSize = 10.sp
                    )
                }
            }

            // Right side items
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
                    Text(
                        text = "Campaigns",
                        fontSize = 10.sp
                    )
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
                    Text(
                        text = "Profile",
                        fontSize = 10.sp
                    )
                }
            }
        }
    }
}
private fun DrawScope.drawCustomShape(
    width: Float,
    height: Float,
    fabOffset: Float,
    inflatedHeight: Float,
    curveHeight: Float
) {
    val path = Path().apply {
        // Move to the top-left corner of the canvas
        moveTo(0f, 0f)

        // Draw the top edge of the rectangle
        lineTo(width, 0f)

        // Draw the line down to where the curve begins
        lineTo(width, height - inflatedHeight)

        // First cubic Bézier curve for the bottom edge
        cubicTo(
            width - (fabOffset / 2), height - inflatedHeight + curveHeight,
            width - (fabOffset / 2), height - (curveHeight / 2),
            width / 2, height - (curveHeight / 2)
        )

        // Control points for the Bézier curve above the FAB
        val controlPoint1X = width / 2 - fabOffset / 2
        val controlPoint1Y = height - inflatedHeight
        val controlPoint2X = width / 2 + fabOffset / 2
        val controlPoint2Y = height - inflatedHeight

        // Bézier curve above the FAB
        cubicTo(
            controlPoint1X, controlPoint1Y,
            controlPoint2X, controlPoint2Y,
            width / 2, height - inflatedHeight
        )

        // Second cubic Bézier curve to close the shape
        cubicTo(
            fabOffset / 2, height - (curveHeight / 2),
            fabOffset / 2, height - inflatedHeight + curveHeight,
            0f, height - inflatedHeight
        )

        // Close the path
        close()
    }

    drawPath(
        path = path,
        color = Color.White
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewBottomnavbar() {
    val navCnltr = rememberNavController()
    CustomBottomNavigationBarWithCanvas(navController = navCnltr) {

    }
}