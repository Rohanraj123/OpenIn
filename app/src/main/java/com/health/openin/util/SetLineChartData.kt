package com.health.openin.util

import android.content.Context
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.core.content.ContextCompat
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter
import com.health.openin.R
import com.health.openin.ui.theme.BlueColor


object SetLineChartData {
    fun setLineChartData(
        context: Context,
        lineChart: LineChart,
    ) {
        // Define X-axis labels
        val xAxisLabels = listOf("11.00 AM", "12.00 PM", "1.00 PM", "2.00 PM", "3.00 PM")

        // Define Y-axis values corresponding to the X-axis labels
        val yAxisEntries = listOf(
            Entry(0f, 25f),
            Entry(1f, 50f),
            Entry(2f, 75f),
            Entry(3f, 100f)
        )

        // Create a LineDataSet with the Y-axis values
        val lineDataSet = LineDataSet(yAxisEntries, "First").apply {
            color = ContextCompat.getColor(context, R.color.blue)
        }

        // Create LineData and set it to the chart
        val lineData = LineData(lineDataSet)
        lineChart.data = lineData
        lineChart.setBackgroundColor(ContextCompat.getColor(context, R.color.white))
        lineChart.animateXY(3000, 3000)

        // Format the X-axis to display custom labels
        val xAxis = lineChart.xAxis
        xAxis.valueFormatter = IndexAxisValueFormatter(xAxisLabels)
        xAxis.position = XAxis.XAxisPosition.BOTTOM
        xAxis.granularity = 1f
        xAxis.setDrawLabels(true)

        // Refresh the chart
        lineChart.invalidate()
    }
}