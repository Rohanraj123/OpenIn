package com.health.openin.view.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.health.openin.ui.theme.BlueColor


@Composable
fun ListHeader(
    onTopLinkButtonClick: () -> Unit,
    onRecentLinkButtonClick: () -> Unit
) {

    var selectedButton by remember { mutableStateOf("Top Links") }

    fun getButtonColor(buttonName: String): Color {
        return if (selectedButton == buttonName) BlueColor else Color.Transparent
    }

    Row (
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(horizontal = 20.dp),
        horizontalArrangement = Arrangement.SpaceEvenly
    ){
        Button(
            onClick = {
                onTopLinkButtonClick()
                selectedButton = "Top Links"
            },
            modifier = Modifier,
            colors = ButtonDefaults.buttonColors(
                containerColor = getButtonColor("Top Links")
            ),
        ) {
            Text(
                text = "Top Links",
                fontSize = 10.sp,
                fontWeight = FontWeight.SemiBold,
                color = if (selectedButton == "Top Links") Color.White else Color.Gray
            )
        }

        Button(
            onClick = {
                onRecentLinkButtonClick()
                selectedButton = "Recent Links"
            },
            modifier = Modifier,
            colors = ButtonDefaults.buttonColors(
                containerColor = getButtonColor("Recent Links")
            ),
        ) {
            Text(
                text = "Recent Links",
                fontSize = 10.sp,
                fontWeight = FontWeight.SemiBold,
                color = if (selectedButton == "Recent Links") Color.White else Color.Gray
            )
        }

        Box(
            modifier = Modifier
                .size(50.dp)
                .padding(5.dp)
                .background(
                    Color.Transparent,
                )
                .border(
                    BorderStroke(1.dp, Color.LightGray),
                    shape = RoundedCornerShape(10.dp)
                )
                .clickable { TODO() },
            contentAlignment = Alignment.Center
        ) {
            Icon(
                Icons.Default.Search,
                contentDescription = null,
                modifier = Modifier.size(20.dp),
                tint = Color.LightGray
            )
        }


    }
}
