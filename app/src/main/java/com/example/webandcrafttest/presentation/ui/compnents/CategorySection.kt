package com.example.webandcrafttest.presentation.ui.compnents

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun CategorySection(
    text:String
){

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp, vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = text, // Display the title of the section
            fontSize = 16.sp,
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.Bold,
            letterSpacing = (-1).sp
        )
        Text(
            text = "View All",
            fontSize = 12.sp,
            modifier = Modifier.clickable { /* TODO: Navigate to all products in this section */ },
            fontWeight = FontWeight.Bold
        )
    }

}