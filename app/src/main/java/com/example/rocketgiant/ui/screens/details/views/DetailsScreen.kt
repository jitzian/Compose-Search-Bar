package com.example.rocketgiant.ui.screens.details.views

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.rocketgiant.ui.app.RocketScreensApp
import com.example.rocketgiant.ui.common.ErrorScreen
import com.example.rocketgiant.ui.common.LoadingScreen
import com.example.rocketgiant.ui.common.MainTopBar
import com.example.rocketgiant.ui.screens.details.viewmodel.DetailsViewModel

@Composable
fun DetailsScreenState(
    detailsViewModel: DetailsViewModel = hiltViewModel(),
    nameParam: String,
    deckParam: String,
    imageUrlParam: String,
    onBackButton: () -> Unit
) {

    val state by detailsViewModel.state.collectAsState()
    detailsViewModel.prepareData(name = nameParam, deck = deckParam, imageUrl = imageUrlParam)

    when (state) {
        is DetailsViewModel.UIState.Loading -> {
            LoadingScreen()
        }
        is DetailsViewModel.UIState.Success -> {
            DetailsScreen(
                nameParam = (state as DetailsViewModel.UIState.Success).name,
                deckParam = (state as DetailsViewModel.UIState.Success).deck,
                imageUrlParam = (state as DetailsViewModel.UIState.Success).imageUrl,
                onBackButton = onBackButton
            )
        }
        is DetailsViewModel.UIState.Error -> {
            ErrorScreen(message = (state as DetailsViewModel.UIState.Error).message)
        }
    }
}

@Composable
fun DetailsScreen(
    nameParam: String,
    deckParam: String,
    imageUrlParam: String,
    onBackButton: () -> Unit
) {
    RocketScreensApp {
        Scaffold(topBar = {
            MainTopBar(
                barTitle = nameParam, showBackButton = true,
                onBackClick = onBackButton
            )
        }) {
            Box(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = "Details go here"
                )
            }
        }
    }
}