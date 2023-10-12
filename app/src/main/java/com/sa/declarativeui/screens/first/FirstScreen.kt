package com.sa.declarativeui.screens.first

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import com.sa.declarativeui.constant.AppDestinations.SecondScreen
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject


@HiltViewModel
class FirstScreenViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private var _state = MutableStateFlow("")
    var state = _state.asStateFlow()

    private val args: String = checkNotNull(savedStateHandle["name"])
    init {
        _state.update { "Hello $args" }
    }

}

@Composable
fun FirstContent(navController: NavHostController) {
    val vm: FirstScreenViewModel = hiltViewModel()
    val name = vm.state.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Yellow),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "First Screen", fontSize = 25.sp)
        Text(text = "Hello ${name.value}", fontSize = 25.sp)
        Button(onClick = {
            navController.navigate(SecondScreen)
        }) {
            Text(text = "Next", fontSize = 25.sp)
        }
    }
}


@Preview(showSystemUi = true)
@Composable
fun _FirstContent() {
}