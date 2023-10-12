package com.sa.declarativeui.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.sa.declarativeui.viewModel.state.ProfileUiState
import dagger.hilt.android.lifecycle.HiltViewModel

@HiltViewModel
class ProfileViewModel : ViewModel() {

//    private var _state = MutableStateFlow(ProfileUiState())
//    val state = _state.asStateFlow()


    var _state by mutableStateOf(ProfileUiState())
        private set

    init {
        getUSerInfo()

    }

    fun getUSerInfo() {
        // call get User Info UseCase
        _state = _state.copy(image = "https://static.printler.com/cache/d/4/1/0/b/b/d410bb4e3906ecaf29094630e1c8899c1bd1f687.jpg")
    }

    fun onChangeFirstName(newValue: String) {
        _state = _state.copy(firstName = newValue)
    }

    fun onChangeLastName(newValue: String) {
        _state = _state.copy(lastName = newValue)
    }

    fun onChangeLocation(newValue: String) {
        _state = _state.copy(location = newValue)
    }

    fun onChangeEmail(newValue: String) {
        _state = _state.copy(email = newValue)
    }

    fun onChangePhone(newValue: String) {
        _state = _state.copy(phone = newValue)
    }

    fun onSaveUser(newValue: String) {
        // saving info useCase
    }
}