package com.health.openin.view.components

import androidx.compose.foundation.BorderStroke
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.health.openin.R
import com.health.openin.ui.theme.BodyColor
import java.sql.Date

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

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(start = 10.dp, end = 10.dp, top = 30.dp)
                    .background(color = Color.White, shape = RoundedCornerShape(10.dp))
            ) {
                Column (
                    modifier = Modifier
                        .wrapContentSize()
                ){
                    Row (
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ){
                        Text(
                            text = "Overview",
                            fontSize = 15.sp,
                            color = Color.Gray,
                        )
                        DateSorting(startDate = "22Aug", endDate = "23 Sept")
                    }
                    Graph()
                }
            }
        }
    }
}

@Composable
fun DateSorting(
    startDate: String,
    endDate: String
) {
    Box(
        modifier = Modifier
            .border(
                BorderStroke(1.dp, Color.LightGray),
                shape = RoundedCornerShape(10.dp)
            ),
    ) {
        Row (
            modifier = Modifier
                .wrapContentSize()
                .padding(vertical = 6.dp, horizontal = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ){
            Text(
                text = startDate,
                fontSize = 12.sp,
            )
            Spacer(modifier = Modifier.width(4.dp))
            Divider(
                modifier = Modifier.width(5.dp),
                thickness = 2.dp,
                color = Color.Black
            )
            Spacer(modifier = Modifier.width(4.dp))
            Text(
                text = endDate,
                fontSize = 12.sp
            )
            Spacer(modifier = Modifier.width(8.dp))
            Icon(
                painter = painterResource(id = R.drawable.clock),
                contentDescription = null,
                modifier = Modifier
                    .size(10.dp)
            )
        }
    }
}
