package com.sa.declarativeui.screens.home

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.sa.declarativeui.constant.AppDestinations.FirstScreen
import com.sa.declarativeui.composables.SpacerVertical16
import com.sa.declarativeui.constant.Screen
import com.sa.declarativeui.screens.first.FirstContent
import com.sa.declarativeui.screens.second.SecondContent
import com.sa.declarativeui.screens.third.ThirdContent
import com.sa.declarativeui.ui.theme.DeclarativeUITheme

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ItemsScreen() {
    DeclarativeUITheme {
        Scaffold {
            val navController = rememberNavController()
            NavHost(navController = navController, "firstScreen") {
                composable(FirstScreen) { FirstContent(navController) }
                composable(Screen.SecondScreen.route) { SecondContent(navController) }
                composable(
                    route = "thirdScreen/{name}",
                    arguments = listOf(
                        navArgument("name") { NavType.StringType }
                    )
                ) { ThirdContent(navController) }
            }
        }
    }
}

@Composable
fun ItemsContent(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Yellow),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Items Screen", fontSize = 25.sp)
        SpacerVertical16()
        Button(onClick = {
            navController.navigate("firstScreen")
        }) {
            Text(text = "Next", fontSize = 25.sp)
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun _ItemsScreen() {
    ItemsScreen()
}