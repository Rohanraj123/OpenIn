package com.health.openin.util

import android.annotation.SuppressLint
import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
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
import okhttp3.internal.format
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter


object SetLineChartData {
    fun setLineChartData(
        context: Context,
        lineChart: LineChart,
        chartData: List<ChartData>
    ) {
        if (chartData.isEmpty()) {
            return // Exit if chartData is empty
        }

        // Convert ChartData to Entry for MPAndroidChart
        val yAxisEntries = chartData.mapIndexed { index, data ->
            Entry(index.toFloat(), data.totalLinks)
        }

        // Generate labels based on the size of chartData
        val xAxisLabels = generateDayLabels(chartData.size)

        val lineDataSet = LineDataSet(yAxisEntries, null).apply {
            color = ContextCompat.getColor(context, R.color.blue)
            lineWidth = 2f
            valueTextColor = ContextCompat.getColor(context, R.color.black)
            valueTextSize = 8f
            setDrawFilled(true)
            setDrawValues(false)
            setDrawCircles(false)
        }

        val lineData = LineData(lineDataSet)
        lineChart.data = lineData
        lineChart.setBackgroundColor(ContextCompat.getColor(context, R.color.white))
        lineChart.animateXY(3000, 3000)

        val xAxis = lineChart.xAxis
        xAxis.valueFormatter = IndexAxisValueFormatter(xAxisLabels)
        xAxis.position = XAxis.XAxisPosition.BOTTOM
        xAxis.granularity = 1f
        xAxis.setDrawLabels(true)
        xAxis.textSize = 12f
        xAxis.setDrawAxisLine(false) // Disable x axis line
        xAxis.setDrawGridLines(false) // Optionally disable x axis grid lines

        lineChart.axisLeft.apply {
            setDrawGridLines(true)
            setDrawAxisLine(false) // Disable left y axis line
            textSize = 12f
        }

        lineChart.axisRight.isEnabled = false
        lineChart.legend.isEnabled = false
        lineChart.description.isEnabled = false

        lineChart.invalidate()
    }

    private fun generateDayLabels(size: Int): List<String> {
        return List(size) { index -> "Day ${index + 1}" }
    }

}