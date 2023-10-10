package com.sa.declarativeui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.sa.declarativeui.ui.theme.DeclarativeUITheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FoodApp() {
    DeclarativeUITheme {
        Scaffold(
            topBar = { TopAppBar(title = { Text(text = "Hello JetPack Compose") }) },
            floatingActionButton = { FloatingActionButton(onClick = { }) {} }
        ) {
            Column(
                modifier = Modifier.fillMaxSize().padding(paddingValues = it),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                CounterScreen()
            }
        }
    }
}