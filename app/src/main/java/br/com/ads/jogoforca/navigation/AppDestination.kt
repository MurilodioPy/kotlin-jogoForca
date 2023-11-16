package br.com.ads.jogoforca.navigation

sealed class AppDestination(val route: String) {
    object Game : AppDestination("game")
    object Temas : AppDestination("temas")
    object Profile : AppDestination("profile")
    object Authentication : AppDestination("authentication")
    object UserRegistration : AppDestination("userRegistration")
}
