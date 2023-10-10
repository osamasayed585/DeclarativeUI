package com.sa.declarativeui.composables

import androidx.compose.foundation.clickable
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.sa.declarativeui.ui.theme.Rubik
import com.sa.declarativeui.ui.theme.orange

@Composable
fun TextButton(
    text: String,
    onClick: () -> Unit = {}
) {
    Text(
        text = text,
        modifier = Modifier.clickable { onClick },
        fontSize = 14.sp,
        fontFamily = Rubik,
        fontWeight = FontWeight.Medium,
        color = orange
    )
}