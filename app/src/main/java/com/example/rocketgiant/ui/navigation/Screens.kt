package com.example.rocketgiant.ui.navigation

sealed class Screens(val route: String) {

    object MainNavScreen : Screens(route = "main_screen")

    object DetailsNavScreen : Screens(route = "details_screen") {
        const val nameParam = "nameParam"
        const val deckParam = "deckParam"
        //const val imageUrlParam = "imageUrlParam"
    }

    // build navigation path (for screen navigation)
    fun withArgs(vararg args: String): String {
        return buildString {
            append(route)
            args.forEach{ arg ->
                append("/$arg")
            }
        }
    }

    // build and setup route format (in navigation graph)
    fun withArgsFormat(vararg args: String) : String {
        return buildString {
            append(route)
            args.forEach{ arg ->
                append("/{$arg}")
            }
        }
    }
}