package com.health.openin.view.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.health.openin.ui.theme.BodyColor

@Composable
fun AppBody(
    name: String,
) {
    Surface (
        modifier = Modifier.fillMaxSize(),
        color = BodyColor,
        shape = RoundedCornerShape(
            topStart = 20.dp,
            topEnd = 20.dp
        )
    ){
        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 20.dp)
        ){
            Text(
                text = "Good morning",
                modifier = Modifier.padding(top = 30.dp),
                fontSize = 15.sp,
                color = Color.Gray
            )
            Text(
                text = name + "\uD83D\uDC4B",
                fontSize = 25.sp,
                fontWeight = FontWeight.SemiBold
            )
        }
    }
}
