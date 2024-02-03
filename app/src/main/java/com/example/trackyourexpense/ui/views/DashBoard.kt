package com.example.trackyourexpense.ui.views

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout

@Composable
fun DashBoardView(){
    ConstraintLayout(
        modifier = Modifier
            .testTag("dashboard-view")
            .fillMaxSize()
            .padding(
                horizontal = 24.dp,
                vertical = 0.dp
            )
    ) {
        val (titleView) = createRefs()
        Text(
            text = "Hello, Amrita",
            modifier = Modifier
                .constrainAs(titleView) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun Preview_DashBoardView() {
    DashBoardView()

}