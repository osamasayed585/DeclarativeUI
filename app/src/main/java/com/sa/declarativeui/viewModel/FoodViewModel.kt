package com.sa.declarativeui.viewModel

import androidx.lifecycle.ViewModel
import com.sa.declarativeui.viewModel.state.FoodUiState
import com.sa.declarativeui.viewModel.state.MealUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

@HiltViewModel
class FoodViewModel : ViewModel() {

    private var _state = MutableStateFlow(FoodUiState())
    val state = _state.asStateFlow()

    init {
        getFoods()
    }

    private fun getFoods() {
        _state.update {
            it.copy(
                meals = listOf(
                    MealUiState(
                        "Spaghetti Carbonara",
                        "https://www.shutterstock.com/image-photo/delicious-spaghetti-served-on-black-260nw-413580649.jpg"
                    ),
                    MealUiState(
                        "Grilled Chicken Salad",
                        "https://upload.wikimedia.org/wikipedia/commons/thumb/9/98/Spaghetti-prepared.jpg/800px-Spaghetti-prepared.jpg"
                    ),
                    MealUiState(
                        "Margherita Pizza",
                        "https://media.istockphoto.com/id/938742222/photo/cheesy-pepperoni-pizza.jpg?s=612x612&w=0&k=20&c=D1z4xPCs-qQIZyUqRcHrnsJSJy_YbUD9udOrXpilNpI="
                    ),
                    MealUiState(
                        "Beef Stir-Fry",
                        "https://media.istockphoto.com/id/810110202/photo/meat-in-chinese-pork-chinese-sauce-mushrooms-green-beans-bell-pepper.jpg?s=612x612&w=0&k=20&c=cRSZa2UEzT8sMdw2SECactoFOyh5KMr1Y-OP-t3geLc="
                    ),
                    MealUiState(
                        "Caesar Salad",
                        "https://media.istockphoto.com/id/544814224/photo/fresh-caesar-salad.jpg?s=612x612&w=0&k=20&c=NMHaT37Is09u4lTsAhOhjASEIW8GoqcdXQqh0iMHWNI="
                    ),
                    MealUiState("Sushi Roll", "https://example.com/sushi.jpg"),
                    MealUiState("Pancakes", "https://example.com/pancakes.jpg"),
                    MealUiState("Burger and Fries", "https://example.com/burger-fries.jpg"),
                    MealUiState("Chocolate Cake", "https://example.com/chocolate-cake.jpg"),
                    MealUiState("Fresh Fruit Salad", "https://example.com/fruit-salad.jpg")
                )
            )
        }
    }

    fun onClickMeal(selectedMeal: MealUiState) {
        _state.update {
            it.copy(
                meals = it.meals.filterNot { meal ->
                    meal.name == selectedMeal.name
                }
            )
        }
    }
}