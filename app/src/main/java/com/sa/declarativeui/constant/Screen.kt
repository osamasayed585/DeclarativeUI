package com.sa.declarativeui.constant

sealed class Screen(val route: String){
    object FirstScreen: Screen(AppDestinations.FirstScreen)
    object SecondScreen: Screen(AppDestinations.FirstScreen)
    object ThirdScreen: Screen(AppDestinations.ThirdScreen)
}
