package com.sa.declarativeui.viewModel

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update


@HiltViewModel
class CounterViewModel : ViewModel() {

    private var _state = MutableStateFlow(0)
    var state = _state.asStateFlow()


    fun onIncreaseCounter() {
        _state.update { it + 1 }
    }

    fun onDecreaseCounter() {
        _state.update { it - 1 }
    }
}