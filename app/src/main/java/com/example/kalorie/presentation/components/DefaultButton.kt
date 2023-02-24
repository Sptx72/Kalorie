package com.example.kalorie.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun DefaultButton(
    text: String,
    errorMessage: String,
    onClick: () -> Unit,
    textColor: Color = Color.White,
    backgroundColor: Color = Color.Black,
    enabled: Boolean = true) {

    Column() {
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
                .height(50.dp),
            shape = RoundedCornerShape(50),
            onClick = { onClick() },
            enabled = enabled,
            colors = ButtonDefaults.buttonColors(backgroundColor = backgroundColor),) {
            Text(
                text = text,
                color = textColor,
                fontWeight = FontWeight.Bold
            )
        }

        Text(
            modifier = Modifier.padding(top = 5.dp),
            text = errorMessage,
            fontSize = 11.sp,
            color = Color.Red
        )
    }

}