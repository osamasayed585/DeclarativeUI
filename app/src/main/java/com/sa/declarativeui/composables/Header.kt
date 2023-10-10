package com.sa.declarativeui.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.sa.declarativeui.ui.theme.Rubik
import com.sa.declarativeui.ui.theme.darkBlack
import com.sa.declarativeui.ui.theme.darkGray

@Composable
fun Header(title: String, subTitle: String) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = title,
            fontSize = 18.sp,
            fontFamily = Rubik,
            fontWeight = FontWeight.Medium,
            color = darkBlack
        )
        Text(
            text = subTitle,
            fontSize = 12.sp,
            fontFamily = Rubik,
            fontWeight = FontWeight.Normal,
            color = darkGray
        )
    }

}

@Preview(showBackground = true, widthDp = 360)
@Composable
fun _Header() {
    Header(title = "Account", subTitle = "Edit Or Mange Your Account")
}