package com.health.openin.util

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.Locale

data class VerticalListCardData(
    val web_link: String,
    val smart_link: String,
    val title: String,
    val total_clicks: Int,
    val original_image: String,
    val thumbnail: String?,
    val times_ago: String,
    val created_at: String,
    val domain_id: String,
    val url_prefix: String?,
    val url_suffix: String?,
    val app: String,
    val is_favourite: Boolean
) {
    val formattedDate: String
        @RequiresApi(Build.VERSION_CODES.O)
        get() {
            val date = LocalDateTime.parse(created_at, DateTimeFormatter.ISO_DATE_TIME)
            return date.format(DateTimeFormatter.ofPattern("dd MMM yyyy", Locale.ENGLISH))
        }
}