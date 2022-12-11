@file:Suppress("FINAL_UPPER_BOUND")

package com.example.rocketgiant.ui.screens.main.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Clear
import androidx.compose.material.icons.rounded.Search
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.input.KeyboardType
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.rocketgiant.R
import com.example.rocketgiant.constants.GlobalConstants.Companion.MAX_LINES
import com.example.rocketgiant.data.remote.model.Result
import com.example.rocketgiant.ui.app.RocketScreensApp
import com.example.rocketgiant.ui.common.*
import com.example.rocketgiant.ui.screens.main.viewmodel.MainViewModel

@Composable
fun MainScreenState(
    navigateToDetails: (String, String) -> Unit,
    mainViewModel: MainViewModel = hiltViewModel()
) {
    val state by mainViewModel.state.collectAsState()
    val fetchGames: (String) -> Unit = { input ->
        mainViewModel.fetchGames(input)
    }
    when (state) {
        is MainViewModel.UIState.Empty -> {
            MainScreen(
                navigateToDetails = navigateToDetails,
                data = emptyList(),
                searchInput = "",
                isLoading = false,
                fetchGames = fetchGames
            )
        }
        is MainViewModel.UIState.Success -> {
            MainScreen(
                navigateToDetails = navigateToDetails,
                data = (state as MainViewModel.UIState.Success).data,
                searchInput = (state as MainViewModel.UIState.Success).searchInput,
                isLoading = (state as MainViewModel.UIState.Success).isLoading,
                fetchGames = fetchGames,
            )
        }
        is MainViewModel.UIState.Error -> {
            ErrorScreen(message = (state as MainViewModel.UIState.Error).message)
        }
    }
}

@Composable
fun <T : Result> MainScreen(
    navigateToDetails: (String, String) -> Unit,
    data: List<T>,
    isLoading: Boolean,
    searchInput: String,
    fetchGames: (String) -> Unit
) {

    val state = rememberLazyListState()
    val scope = rememberCoroutineScope()

    // Immediately update and keep track of query from text field changes.
    var query: String by rememberSaveable { mutableStateOf("") }
    var showClearIcon by rememberSaveable { mutableStateOf(false) }

    if (query.isEmpty()) {
        showClearIcon = false
    } else if (query.isNotEmpty()) {
        showClearIcon = true
    }

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

            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.dimen_4_dp))
            ) {
                if (isLoading) {
                    LoadingScreen()
                } else {
                    //----------------------------------------
                    //InputSearchBar(fetchGames, searchInput)
                    TextField(
                        value = query,
                        onValueChange = { onQueryChanged ->
                            // If user makes changes to text, immediately updated it.
                            query = onQueryChanged
                            // To avoid crash, only query when string isn't empty.
                            if (onQueryChanged.isNotEmpty()) {
                                // Pass latest query to refresh search results.
                                fetchGames.invoke(onQueryChanged)
                            }
                        },
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Rounded.Search,
                                tint = MaterialTheme.colors.onBackground,
                                contentDescription = stringResource(id = R.string.search_icon_text_query)
                            )
                        },
                        trailingIcon = {
                            if (showClearIcon) {
                                IconButton(onClick = { query = "" }) {
                                    Icon(
                                        imageVector = Icons.Rounded.Clear,
                                        tint = MaterialTheme.colors.onBackground,
                                        contentDescription = stringResource(id = R.string.clear_icon_text_query)
                                    )
                                }
                            }
                        },
                        maxLines = MAX_LINES,
                        colors = TextFieldDefaults.textFieldColors(backgroundColor = Color.Transparent),
                        placeholder = { Text(text = stringResource(R.string.hint_search_query)) },
                        textStyle = MaterialTheme.typography.subtitle1,
                        singleLine = true,
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(
                                color = MaterialTheme.colors.background,
                                shape = RectangleShape
                            )
                    )
                    //----------------------------------------
                    LazyColumn(state = state) {
                        items(data) { item ->
                            RowItem(
                                data = item,
                                onItemClick = {
                                    navigateToDetails(
                                        item.name ?: "",
                                        item.deck ?: ""
                                    )
                                }
                            )
                        }
                    }
                }
            }
            if (data.isNotEmpty()) {
                ScrollFloatingButton(state = state, coroutineScope = scope, data = data)
            }
        }
    }
}

