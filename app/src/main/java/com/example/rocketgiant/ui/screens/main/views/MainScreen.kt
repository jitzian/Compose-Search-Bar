@file:Suppress("FINAL_UPPER_BOUND")

package com.example.rocketgiant.ui.screens.main.views

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.semantics
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.rocketgiant.data.remote.model.Result
import com.example.rocketgiant.ui.app.RocketScreensApp
import com.example.rocketgiant.ui.common.*
import com.example.rocketgiant.ui.screens.main.viewmodel.MainViewModel

@Composable
fun MainScreenState(
    mainViewModel: MainViewModel = hiltViewModel(),
    navigateToDetails: (String, String) -> Unit
) {

    val state by mainViewModel.state.collectAsState()
    mainViewModel.fetchGames()

    when (state) {
        is MainViewModel.UIState.Loading -> {
            LoadingScreen()
        }
        is MainViewModel.UIState.Success -> {
            MainScreen(
                data = ((state as MainViewModel.UIState.Success).data),
                navigateToDetails = navigateToDetails
            )
        }
        is MainViewModel.UIState.Error -> {
            ErrorScreen(message = (state as MainViewModel.UIState.Error).message)
        }
    }
}

@Composable
fun <T : Result> MainScreen(data: List<T>, navigateToDetails: (String, String) -> Unit) {
    val state = rememberLazyListState()
    val scope = rememberCoroutineScope()
    RocketScreensApp {
        Scaffold(
            topBar = {
                MainTopBar(
                    showBackButton = false,
                    barTitle = "Search for games" // TODO: Move this to the resource file
                )
            },
            modifier = Modifier
                .semantics(mergeDescendants = true) {}
            //.testTag(stringResource(id = R.string.pizzaScreen_test_TAG))
        ) {
            LazyColumn(state = state) {
                items(data) { item ->
                    RowItem(
                        data = item,
                        onItemClick = { navigateToDetails(item.name ?: "", item.deck ?: "") }
                    )
                }
            }
            ScrollFloatingButton(state = state, coroutineScope = scope, data = data)
        }
    }
}