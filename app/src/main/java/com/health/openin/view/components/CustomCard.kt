package com.health.openin.view.components


import android.content.Intent
import android.net.Uri
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import coil.compose.rememberAsyncImagePainter
import com.health.openin.R
import com.health.openin.ui.theme.BlueColor
import com.health.openin.util.dashedBorder


@Composable
fun CustomCard(
    thumbnail: String,
    title: String,
    date: String,
    totalClicks: Int,
    url: String,
) {
    val truncatedTitle = if (title.length > 16) {
        title.take(16) + ".."
    } else {
        title
    }

    Column(
        modifier = Modifier
            .padding(start = 8.dp, end = 8.dp, top = 8.dp)
            .fillMaxWidth()
    ) {
        // Upper Part with More Height
        Card(
            modifier = Modifier // Space between Card and DashedBorderBox
                .fillMaxWidth()
                .height(90.dp), // Adjust height to make the Card taller
            shape = RoundedCornerShape(
                topStart = 10.dp,
                topEnd = 10.dp
            ),
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            )
        ) {
            Row(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row {
                    Image(
                        painter = rememberAsyncImagePainter(model = thumbnail),
                        contentDescription = null,
                        modifier = Modifier.size(40.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Column(
                        modifier = Modifier.padding(start = 8.dp)
                    ) {
                        Text(
                            text = truncatedTitle,
                            fontSize = 16.sp
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = date,
                            fontSize = 11.sp,
                            color = Color.Gray
                        )
                    }
                }

                Column(
                    modifier = Modifier.padding(start = 8.dp)
                ) {
                    Text(
                        text = totalClicks.toString(),
                        fontSize = 16.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "Clicks",
                        fontSize = 10.sp,
                        color = Color.Gray
                    )
                }
            }
        }
        // Lower Part with Dashed Border and Less Height
        DashedBorderBox(url = url)
    }
}

@Composable
fun DashedBorderBox(url: String) {
    val truncatedUrl = if (url.length > 25) url.take(25) + ".." else url
    val context = LocalContext.current

    fun onClick(url: String) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        context.startActivity(intent)
    }

    Box(
        modifier = Modifier
            .padding( bottom = 25.dp) // Padding for the Box
            .fillMaxWidth()
            .clickable { onClick(url) }
            .dashedBorder(
                color = BlueColor.copy(.3f),
                shape = RoundedCornerShape(
                    bottomStart = 12.dp,
                    bottomEnd = 12.dp
                )
            )
            .background(
                BlueColor.copy(alpha = .2f),
                shape = RoundedCornerShape(
                    bottomStart = 12.dp,
                    bottomEnd = 12.dp
                )
            ) // Background color for the Box
            .padding(horizontal = 12.dp, vertical = 4.dp) // Padding inside the Box
            .height(40.dp) // Set a fixed height for the DashedBorderBox
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = truncatedUrl,
                color = BlueColor,
                fontSize = 14.sp,
                modifier = Modifier
                    .clickable {
                        onClick(url)
                        Log.d("CustomCard", "Link processing: ${Uri.parse(url)}")
                    }
            )
            IconButton(
                onClick = { /*TODO*/ }
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.copy),
                    contentDescription = null,
                    modifier = Modifier.size(16.dp)
                )
            }
        }
    }
}
