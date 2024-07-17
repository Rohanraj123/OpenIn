package com.health.openin.view.components

import android.content.Context
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.github.mikephil.charting.charts.LineChart
import com.health.openin.R
import com.health.openin.util.ChartData
import com.health.openin.util.SetLineChartData
import com.health.openin.viewmodel.DashboardScreenViewModel

@Composable
fun Graph(
    dashboardScreenViewModel: DashboardScreenViewModel
) {
    val context = LocalContext.current

    val apiData by dashboardScreenViewModel.apiData.collectAsState()

    val chartData = apiData?.data?.overall_url_chart?.let { chartMap ->
        chartMap.entries.mapIndexed { index, entry ->
            ChartData(date = entry.key, totalLinks = entry.value.toFloat())
        }
    } ?: emptyList()

    Column (
        modifier = Modifier.padding(16.dp)
    ){
        AndroidView(factory = {ctx ->
            LineChart(ctx).apply {
                SetLineChartData.setLineChartData(context, this, chartData)
            }
        },
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
            )
    }
}