package com.sa.declarativeui.screens.profile

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import com.sa.declarativeui.R
import com.sa.declarativeui.composables.CardText
import com.sa.declarativeui.composables.Header
import com.sa.declarativeui.composables.PainterImage
import com.sa.declarativeui.composables.SpacerVertical24
import com.sa.declarativeui.composables.SpacerVertical32
import com.sa.declarativeui.composables.TextButton
import com.sa.declarativeui.ui.theme.Rubik
import com.sa.declarativeui.ui.theme.green
import com.sa.declarativeui.viewModel.state.ProfileUiState
import com.sa.declarativeui.viewModel.ProfileViewModel


@Composable
fun ProfileScreen(
    viewModel: ProfileViewModel = hiltViewModel()
) {
    val state = viewModel._state

    ProfileContent(
        state = state,
        onFirstNameChange = viewModel::onChangeFirstName,
        onLastNameChange = viewModel::onChangeLastName,
        onLocationChange = viewModel::onChangeLocation,
        onEmailChange = viewModel::onChangeEmail,
        onPhoneChange = viewModel::onChangePhone
    )
}

@Composable
fun ProfileContent(
    state: ProfileUiState,
    onFirstNameChange: (String) -> Unit,
    onLastNameChange: (String) -> Unit,
    onLocationChange: (String) -> Unit,
    onEmailChange: (String) -> Unit,
    onPhoneChange: (String) -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp, vertical = 32.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Header(
            title = stringResource(R.string.account),
            subTitle = stringResource(R.string.edit_or_mange_your_account)
        )
        SpacerVertical32()
        PainterImage(painter = rememberAsyncImagePainter(model = state.image))
        SpacerVertical24()
        TextButton(text = stringResource(R.string.change_profile_picture))
        Row(
            modifier = Modifier.fillMaxWidth(),
        ) {
            Box(
                modifier = Modifier
                    .weight(0.5f)
                    .padding(end = 8.dp)
            ) {
                CardText(
                    title = stringResource(R.string.first_name),
                    message = state.firstName,
                    onValueChange = onFirstNameChange
                )
            }
            Box(
                modifier = Modifier
                    .weight(0.5f)
                    .padding(start = 8.dp)
            ) {
                CardText(
                    title = stringResource(R.string.last_name),
                    message = state.lastName,
                    onValueChange = onLastNameChange
                )
            }
        }
        CardText(
            title = stringResource(R.string.location),
            message = state.location,
            onValueChange = onLocationChange
        )
        CardText(
            title = stringResource(R.string.email),
            message = state.email,
            onValueChange = onEmailChange
        )
        CardText(
            title = stringResource(R.string.phone),
            message = state.phone,
            onValueChange = onPhoneChange
        )

        Spacer(modifier = Modifier.weight(1f))

        Button(
            modifier = Modifier
                .fillMaxWidth()
                .height(54.dp),
            shape = RoundedCornerShape(16.dp),
            colors = ButtonDefaults.buttonColors(containerColor = green),
            elevation = ButtonDefaults.buttonElevation(0.dp),
            onClick = { },
        ) {
            Text(
                fontSize = 16.sp,
                fontFamily = Rubik,
                fontWeight = FontWeight.Medium,
                color = Color.White,
                text = "Save"
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun _ProfileContent() {
    ProfileContent(
        ProfileUiState(),
        onFirstNameChange = {},
        onLastNameChange = {},
        onLocationChange = {},
        onEmailChange = {},
        onPhoneChange = {}
    )
}