package com.example.kalorie.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SmallText(
    text: String,
    paddingValues: PaddingValues = PaddingValues(5.dp),
    onClick: ()-> Unit? = {}
) {
    Text(
        modifier = Modifier
            .padding(paddingValues = paddingValues)
            .clickable { onClick() },
        text = text,
        color = Color.Gray,
        fontWeight = FontWeight.Light,
        fontSize = 15.sp)
}