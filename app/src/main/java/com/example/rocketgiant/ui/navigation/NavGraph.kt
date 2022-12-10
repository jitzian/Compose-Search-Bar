package com.example.rocketgiant.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.rocketgiant.ui.screens.details.views.DetailsScreenState
import com.example.rocketgiant.ui.screens.main.views.MainScreenState

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screens.MainNavScreen.route
    ) {
        addMainScreen(navController, this)
        addDetailsScreen(navController, this)
    }
}

private fun addMainScreen(
    navController: NavHostController,
    navGraphBuilder: NavGraphBuilder
) {
    navGraphBuilder.composable(route = Screens.MainNavScreen.route) {
        MainScreenState(
            navigateToDetails = { nameParam, deckParam ->
                navController.navigate(Screens.DetailsNavScreen.withArgs(nameParam, deckParam))
            }
        )
    }
}

private fun addDetailsScreen(
    navController: NavHostController,
    navGraphBuilder: NavGraphBuilder
) {
    navGraphBuilder.composable(
        route = Screens.DetailsNavScreen.withArgsFormat(
            Screens.DetailsNavScreen.nameParam,
            Screens.DetailsNavScreen.deckParam
        ),
        arguments = listOf(
            navArgument(Screens.DetailsNavScreen.nameParam) {
                type = NavType.StringType
            },
            navArgument(Screens.DetailsNavScreen.deckParam) {
                type = NavType.StringType
            }
        )
    ) { navBackStackEntry ->
        val args = navBackStackEntry.arguments
        DetailsScreenState(
            nameParam = args?.getString(Screens.DetailsNavScreen.nameParam) ?: "",
            deckParam = args?.getString(Screens.DetailsNavScreen.deckParam) ?: "",
            onBackButton = {
                navController.popBackStack()
            }
        )
    }
}
