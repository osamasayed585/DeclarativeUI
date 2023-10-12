package com.sa.declarativeui.screens.constraint

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout

@Preview(showSystemUi = true)
@Composable
fun Constraint() {
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {

        val (button, fab, text) = createRefs()
        val guideline = createGuidelineFromTop(32.dp)
        val verticalGuideLine = createGuidelineFromEnd(0.54f)

        Button(
            onClick = { },
            modifier = Modifier.constrainAs(button) {
                top.linkTo(guideline)
                bottom.linkTo(parent.bottom)
                start.linkTo(parent.start)


            }
        ) {

        }

        FloatingActionButton(onClick = { /*TODO*/ }, modifier = Modifier.constrainAs(fab) {
            bottom.linkTo(parent.bottom, 32.dp)
            end.linkTo(parent.end, 32.dp)
        }) {
        }

        Text(
            text = "First Constrain layout",
            modifier = Modifier.constrainAs(text) {
                top.linkTo(button.bottom)
                end.linkTo(button.end)
                start.linkTo(button.start)
            }

        )
    }
}