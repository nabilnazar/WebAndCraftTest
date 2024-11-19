package com.example.webandcrafttest.presentation.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.sp


@Composable
fun CartScreen() {

    val rainbowColors = listOf(
        Color.Magenta,
        Color.Yellow,
        Color.Cyan,
        Color.Green,
        Color.Blue,

        )
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(Color.White, Color.Black),
                    start = Offset(1f, 5f),
                    end = Offset(1500f, 0f) // Adjust end offset as needed
                )
            ),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = buildAnnotatedString {
                withStyle(
                    SpanStyle(
                        brush = Brush.linearGradient(
                            colors = rainbowColors
                        )
                    )
                ) {
                    append("cart is empty \uD83D\uDE0A")
                }
            }, fontSize = 34.sp, fontWeight = FontWeight.Bold, fontFamily = FontFamily.Cursive
        )
    }
}
