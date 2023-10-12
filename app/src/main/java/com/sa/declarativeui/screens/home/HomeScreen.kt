package com.sa.declarativeui.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sa.declarativeui.R
import com.sa.declarativeui.ui.theme.DeclarativeUITheme


@Composable
fun HomeScreen() {
    Greeting("Usama's")
    Greeting("Ali's")
    Greeting("Khaled's")
}

@Composable
fun Greeting(name: String) {
    Text(text = "$name")
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    DeclarativeUITheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly

        ) {

            val textShadowModifier = Modifier
                .shadow(10.dp, spotColor = Color.Green)
                .fillMaxWidth()
                .background(Color.Gray)
                .padding(16.dp)

            Text(
                modifier = textShadowModifier,
                text = stringResource(R.string.hello_usama),
                fontSize = 24.sp
            )

            Text(
                modifier = textShadowModifier.background(Color.Yellow),
                text = stringResource(R.string.another_composable_text),
                fontSize = 24.sp
            )
        }
    }
}