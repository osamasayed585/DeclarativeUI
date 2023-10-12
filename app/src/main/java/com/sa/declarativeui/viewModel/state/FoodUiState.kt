package com.sa.declarativeui.viewModel.state

data class FoodUiState(
    val meals: List<MealUiState> = emptyList()
)

data class MealUiState(
    val name: String,
    val imageUtl: String
)
