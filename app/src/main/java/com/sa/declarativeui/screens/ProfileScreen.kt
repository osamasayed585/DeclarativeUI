package com.sa.declarativeui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sa.declarativeui.R
import com.sa.declarativeui.composables.CardText
import com.sa.declarativeui.composables.Header
import com.sa.declarativeui.composables.PainterImage
import com.sa.declarativeui.composables.SpacerVertical24
import com.sa.declarativeui.composables.SpacerVertical32
import com.sa.declarativeui.composables.TextButton
import com.sa.declarativeui.ui.theme.Rubik
import com.sa.declarativeui.ui.theme.green

@Preview(showBackground = true)
@Composable
fun ProfileScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp, vertical = 32.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Header(title = "Account", subTitle = "Edit Or Mange Your Account")
        SpacerVertical32()
        PainterImage(painter = painterResource(id = R.drawable.img_profile))
        SpacerVertical24()
        TextButton(text = "change profile picture")
        Row(
            modifier = Modifier.fillMaxWidth(),
        ) {
            Box(
                modifier = Modifier
                    .weight(0.5f)
                    .padding(end = 8.dp)
            ) {
                CardText(title = "First name", message = "Osame")
            }
            Box(
                modifier = Modifier
                    .weight(0.5f)
                    .padding(start = 8.dp)
            ) {
                CardText(title = "Last Name", message = "Sayed")
            }
        }
        CardText(title = "Location", message = "Cairo, Nasr city")
        CardText(title = "Email", message = "osama@gmail.com")
        CardText(title = "Phone", message = "01285692254")

        Spacer(modifier = Modifier.weight(1f))

        Button(
            modifier = Modifier
                .fillMaxWidth()
                .height(54.dp),
            shape = RoundedCornerShape(16.dp),
            colors = ButtonDefaults.buttonColors(containerColor = green),
            elevation = ButtonDefaults.buttonElevation(0.dp),
            onClick = { },
        ) {
            Text(
                fontSize = 16.sp,
                fontFamily = Rubik,
                fontWeight = FontWeight.Medium,
                color = Color.White,
                text = "Save"
            )
        }
    }
}