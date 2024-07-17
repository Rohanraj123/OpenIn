package com.health.openin.view.components

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.health.openin.R
import com.health.openin.ui.theme.BodyColor
import com.health.openin.ui.theme.C1Color
import com.health.openin.ui.theme.C2Color
import com.health.openin.ui.theme.Pink40
import com.health.openin.util.CardData
import com.health.openin.util.VerticalListCardData
import com.health.openin.viewmodel.DashboardScreenViewModel
import kotlinx.coroutines.delay
import java.time.LocalDateTime
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun AppBody(
    name: String,
    dashboardScreenViewModel: DashboardScreenViewModel
) {

    val apiData by dashboardScreenViewModel.apiData.collectAsState()
    var topLinkList by remember { mutableStateOf(emptyList<VerticalListCardData>()) }
    var recentLinkList by remember { mutableStateOf(emptyList<VerticalListCardData>()) }
    var currentTime by remember { mutableStateOf(LocalDateTime.now()) }
    var viewMode by remember { mutableStateOf("top") } // Track the current view mode

    // Update the time every second
    LaunchedEffect(Unit) {
        while (true) {
            currentTime = LocalDateTime.now()
            delay(1000L)
        }
    }

    val hour = currentTime.hour
    val greeting = when {
        hour in 6..11 -> "Good Morning\uD83C\uDF1E"
        hour in 12..17 -> "Good Afternoon\uD83C\uDF05"
        hour in 18..21 -> "Good Evening\uD83C\uDF07"
        else -> "Good Night\uD83C\uDF19"
    }

    LaunchedEffect(Unit) {
        Log.d("AppBody", "Fetching data...")
        dashboardScreenViewModel.getData()
    }

    LaunchedEffect(apiData) {
        apiData?.data?.recent_links.let { recentLinkItems ->
            if (recentLinkItems != null) {
                recentLinkList = recentLinkItems.map { item ->
                    VerticalListCardData(
                        web_link = item.web_link,
                        smart_link = item.smart_link,
                        title = item.title,
                        total_clicks = item.total_clicks,
                        original_image = item.original_image,
                        thumbnail = item.thumbnail,
                        times_ago = item.times_ago,
                        created_at = item.created_at,
                        domain_id = item.domain_id,
                        url_prefix = item.url_prefix,
                        url_suffix = item.url_suffix,
                        app = item.app,
                        is_favourite = item.is_favourite
                    )
                }
            }
        }
        apiData?.data?.top_links?.let { topLinkItems ->
            topLinkList = topLinkItems.map { item ->
                VerticalListCardData(
                    web_link = item.web_link,
                    smart_link = item.smart_link,
                    title = item.title,
                    total_clicks = item.total_clicks,
                    original_image = item.original_image,
                    thumbnail = item.thumbnail,
                    times_ago = item.times_ago,
                    created_at = item.created_at,
                    domain_id = item.domain_id,
                    url_prefix = item.url_prefix,
                    url_suffix = item.url_suffix,
                    app = item.app,
                    is_favourite = item.is_favourite
                )
            }
            Log.d("AppBody", "List updated with size: ${topLinkList.size}")
        } ?: Log.d("AppBody", "apiData or top_links is null")
    }

    val cardDataList = listOf(
        CardData(
            icon = painterResource(id = R.drawable.hc_1),
            content = apiData?.total_clicks.toString(),
            title = "Today's Clicks",
            color = C1Color
        ),
        CardData(
            icon = painterResource(id = R.drawable.hc_2),
            content = apiData?.top_location.toString(),
            title = "Top Location",
            color = C2Color
        ),
        CardData(
            icon = painterResource(id = R.drawable.hc_3),
            content = apiData?.top_source.toString(),
            title = "Top Source",
            color = Pink40
        )
    )

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = BodyColor,
        shape = RoundedCornerShape(
            topStart = 20.dp,
            topEnd = 20.dp
        )
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 10.dp)
        ) {
            item {
                Text(
                    text = greeting,
                    modifier = Modifier.padding(top = 30.dp),
                    fontSize = 15.sp,
                    color = Color.Gray
                )
                Text(
                    text = "$name \uD83D\uDC4B",
                    fontSize = 25.sp,
                    fontWeight = FontWeight.SemiBold
                )

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 10.dp, end = 10.dp, top = 30.dp)
                        .background(color = Color.White, shape = RoundedCornerShape(10.dp))
                ) {
                    Column(
                        modifier = Modifier.padding(10.dp)
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                text = "Overview",
                                fontSize = 15.sp,
                                color = Color.Gray,
                            )
                            DateSorting(startDate = "22Aug", endDate = "23 Sept")
                        }
                        Graph(dashboardScreenViewModel)
                    }
                }

                HorizontalCardRow(cardDataList = cardDataList)
                FullWidthBox(
                    icon = painterResource(id = R.drawable.priceboost),
                    text = "View Analytics",
                    onClick = {

                    }
                )
                ListHeader(
                    onTopLinkButtonClick = {
                        viewMode = "top"
                    },
                    onRecentLinkButtonClick = {
                        viewMode = "recent"
                    }
                )
            }

            Log.d("AppBody", "Rendering items with viewMode: $viewMode")
            items(
                when (viewMode) {
                    "top" -> topLinkList
                    "recent" -> recentLinkList
                    "all" -> topLinkList + recentLinkList
                    else -> emptyList()
                }
            ) { item ->
                Log.d("AppBody", "Item: ${item.title}, Thumbnail: ${item.thumbnail}")
                Log.d("AppBody", "Rendering CustomCard for item: ${item.title}")
                CustomCard(
                    thumbnail = item.original_image,
                    title = item.title,
                    date = item.formattedDate ?: "",
                    totalClicks = item.total_clicks,
                    url = item.web_link
                )
            }
            item {
                Footer(
                    apiData?.support_whatsapp_number.toString(),
                    onClick = {
                        viewMode = "all"
                    }
                )
            }
        }
    }
}
