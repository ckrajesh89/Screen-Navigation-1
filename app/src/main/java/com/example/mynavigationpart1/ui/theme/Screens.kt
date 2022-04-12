package com.example.mynavigationpart1.ui.theme

sealed class Screens (val route: String){
    object MainScreen: Screens ("MainScreen")
    object DetailScreen: Screens("DetailScreen")

    fun withArgs(vararg args: String): String {
        return buildString {
            append(route)
            args.forEach{ arg ->
                append("/$arg")
            }
        }
    }
}

