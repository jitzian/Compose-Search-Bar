package com.example.rocketgiant.ui.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.rocketgiant.R
import com.example.rocketgiant.ui.app.RocketScreensApp

@Composable
fun ErrorScreen(message: String?) {
    RocketScreensApp {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painterResource(R.drawable.broken_robot),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .width(dimensionResource(id = R.dimen.cell_extra_width))
                    .height(dimensionResource(id = R.dimen.cell_extra_width))
                    .padding(dimensionResource(id = R.dimen.dimen_16_dp))
                    .testTag(stringResource(id = R.string.errorScreen_broken_robot_test_TAG))
            )
            Text(
                text = message ?: stringResource(id = R.string.no_internet_connection_TEXT),
                modifier = Modifier
                    .padding(dimensionResource(id = R.dimen.dimen_16_dp))
                    .testTag(stringResource(id = R.string.errorScreen_error_text_test_TAG)),
                style = MaterialTheme.typography.h5
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PrevErrorScreen() {
    ErrorScreen(message = "Message to be displayed")
}