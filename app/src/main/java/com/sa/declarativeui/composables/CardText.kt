package com.sa.declarativeui.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sa.declarativeui.ui.theme.Rubik
import com.sa.declarativeui.ui.theme.cardBackgroundColor
import com.sa.declarativeui.ui.theme.seconderTextColor


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CardText(title: String, message: String, onValueChange: (String) -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(cardBackgroundColor),
        elevation = CardDefaults.cardElevation(0.dp),
    ) {
        Column(
            modifier =
            Modifier.padding(vertical = 12.dp, horizontal = 24.dp)
        ) {
            Text(
                text = title,
                fontSize = 12.sp,
                fontFamily = Rubik,
                fontWeight = FontWeight.Normal,
                color = seconderTextColor
            )
//            Text(
//                text = message,
//                fontSize = 16.sp,
//                fontFamily = Rubik,
//                fontWeight = FontWeight.Normal,
//                color = Color.Black
//            )
            BasicTextField(
                value = message,
                onValueChange = { onValueChange(it) }
            )
        }

    }
}

@Preview(showBackground = true)
@Composable
fun _Card() {
    CardText(title = "location", message = "Cairo - Nsr city"){}
}