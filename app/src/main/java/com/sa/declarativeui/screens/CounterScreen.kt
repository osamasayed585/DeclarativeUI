package com.sa.declarativeui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.sa.declarativeui.viewModel.CounterViewModel

@Composable
fun CounterScreen(viewModel: CounterViewModel = hiltViewModel()) {
    val state = viewModel.state.collectAsState()
    CounterContent(
        state = state.value.toString(),
        onAddClick = viewModel::onIncreaseCounter,
        onMinusClick = viewModel::onDecreaseCounter,
    )
}

@Composable
fun CounterContent(
    state: String,
    onAddClick: () -> Unit,
    onMinusClick: () -> Unit,

    ) {

    Column(horizontalAlignment = Alignment.CenterHorizontally) {

        Text(
            text = state,
            fontSize = 20.sp
        )

        Spacer(modifier = Modifier.height(30.dp))

        Row {

            IconButton(onClick = { onAddClick() }) {
                Icon(
                    imageVector = Icons.Filled.Add,
                    contentDescription = "Plus"
                )
            }

            Spacer(modifier = Modifier.width(30.dp))

            IconButton(onClick = { onMinusClick() }) {
                Icon(
                    imageVector = Icons.Filled.Close,
                    contentDescription = "Minus"
                )
            }
        }

    }
}

@Preview(showSystemUi = true)
@Composable
fun _CounterContent() {
    CounterContent(
        state = "",
        onAddClick = {},
        onMinusClick = {},
    )
}