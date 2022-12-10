package com.example.rocketgiant.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.rocketgiant.ui.screens.main.views.MainScreen
import com.example.rocketgiant.ui.screens.main.views.MainScreenState

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screens.MainScreen.route
    ) {
        addMainScreen(navController, this)
        addDetailsScreen(navController, this)
    }
}

private fun addMainScreen(
    navController: NavHostController,
    navGraphBuilder: NavGraphBuilder
) {
    navGraphBuilder.composable(route = Screens.MainScreen.route) {
        MainScreenState()
    }
}

private fun addDetailsScreen(
    navController: NavHostController,
    navGraphBuilder: NavGraphBuilder
) {

}