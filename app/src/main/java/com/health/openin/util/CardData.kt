package com.health.openin.util

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter

data class CardData(
    val icon: Painter,
    val content: String,
    val title: String,
    val color: Color
)
