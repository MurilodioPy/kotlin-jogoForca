package br.com.ads.jogoforca.navigation

sealed class AppDestination(val route: String) {
    object Game : AppDestination("game")
    object Temas : AppDestination("temas")
    object Profile : AppDestination("profile")
    object Authentication : AppDestination("authentication")
    object UserRegistration : AppDestination("userRegistration")
}

//val bottomAppBarItems = listOf(
//    BottomAppBarItem(
//        label = "Destaques",
//        icon = Icons.Filled.AutoAwesome,
//        destination = AppDestination.Highlight
//    ),
//    BottomAppBarItem(
//        label = "Menu",
//        icon = Icons.Filled.RestaurantMenu,
//        destination = AppDestination.Menu
//    ),
//    BottomAppBarItem(
//        label = "Bebidas",
//        icon = Icons.Outlined.LocalBar,
//        destination = AppDestination.Drinks
//    ),
//)