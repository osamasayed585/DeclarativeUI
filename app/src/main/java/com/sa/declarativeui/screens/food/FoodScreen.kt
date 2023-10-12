package com.sa.declarativeui.screens.food

import MealItem
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.sa.declarativeui.viewModel.FoodViewModel
import com.sa.declarativeui.viewModel.state.FoodUiState
import com.sa.declarativeui.viewModel.state.MealUiState

@Composable
fun FoodScreen(
    viewModel: FoodViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState()
    FoodContent(
        state = state,
        onItemClick = viewModel::onClickMeal
    )
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun FoodContent(
    state: FoodUiState,
    onItemClick: (MealUiState) -> Unit
) {
    LazyColumn(
        Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item { Text(text = "Menu") }
        items(items = state.meals, key = { it.name }) {
            MealItem(
                meal = it,
                onItemClick = onItemClick,
                modifier = Modifier.animateItemPlacement()
            )
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun _FoodContent() {
    FoodContent(FoodUiState()) {
    }
}