package com.health.openin.view.components

import android.content.Context
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.github.mikephil.charting.charts.LineChart
import com.health.openin.R
import com.health.openin.util.SetLineChartData

@Composable
fun Graph(

) {
    val context = LocalContext.current

    Column (
        modifier = Modifier.padding(16.dp)
    ){
        AndroidView(factory = {ctx ->
            LineChart(ctx).apply {
                SetLineChartData.setLineChartData(context, this)
            }
        },
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
            )
    }
}