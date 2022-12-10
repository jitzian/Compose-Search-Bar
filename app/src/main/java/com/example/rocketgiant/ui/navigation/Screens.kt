package com.example.rocketgiant.ui.navigation

open class Screens(val route: String) {

    object MainScreen : Screens(route = "main_screen")

    object DetailsScreen : Screens(route = "details_screen")

    // build navigation path (for screen navigation)
    fun withArgs(vararg args: String): String {
        return buildString {
            append(route)
            args.forEach { arg ->
                append("/$arg")
            }
        }
    }

    // build and setup route format (in navigation graph)
    fun withArgsFormat(vararg args: String): String {
        return buildString {
            append(route)
            args.forEach { arg ->
                append("/{$arg}")
            }
        }
    }

}