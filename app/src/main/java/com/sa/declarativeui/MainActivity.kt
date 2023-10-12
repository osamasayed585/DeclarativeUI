package com.sa.declarativeui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.sa.declarativeui.screens.FoodApp
import com.sa.declarativeui.screens.food.FoodScreen
import com.sa.declarativeui.screens.home.ItemsScreen
import com.sa.declarativeui.screens.profile.ProfileScreen


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { FoodScreen() }
    }
}