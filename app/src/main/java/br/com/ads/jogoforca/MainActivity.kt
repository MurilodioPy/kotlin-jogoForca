package br.com.ads.jogoforca

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.com.ads.jogoforca.navigation.AppDestination
import br.com.ads.jogoforca.ui.theme.screens.AuthenticationScreen
import br.com.ads.jogoforca.ui.theme.screens.GameScreen
import br.com.ads.jogoforca.ui.theme.screens.ProfileScreen
import br.com.ads.jogoforca.ui.theme.screens.SplashScreen
import br.com.ads.jogoforca.ui.theme.screens.TemasScreen
import br.com.ads.jogoforca.ui.theme.screens.ui.theme.JogoForcaTheme
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
//            var daoTema : DAOTema
//            daoTema = DAOTema(applicationContext)
//            daoTema.inserirTemas()
            JogoForcaTheme {
                var splashScreenVisible by remember { mutableStateOf(true) }

                LaunchedEffect(Unit) {
                    delay(3000) // Aguarda por 3 segundos (ajuste conforme necessário)
                    splashScreenVisible = false
                }
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    if (splashScreenVisible) {
                        SplashScreen()
                    } else {
                        MyApp()
                    }
                }
            }
        }
    }
}

@Composable
fun MyApp(){
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = AppDestination.Temas.route+"/{user}"
    ) {
        composable(AppDestination.Temas.route+"/{user}") { entry ->
            entry.arguments?.getString("user")?.let{ user ->
                TemasScreen(
                    user = user,
                    navController
                )
            } ?: LaunchedEffect(null){
                navController.navigate(AppDestination.Authentication.route)
            }
        }
        composable(AppDestination.Authentication.route) {
            AuthenticationScreen(
                onEnterClick = { user ->
                    navController.navigate(AppDestination.Temas.route+"/${user}")
                }
            )
        }
        composable(AppDestination.Game.route+"/{id}") { entry ->
            entry.arguments?.getString("id")?.let{id ->
                GameScreen(id, navController)
            }
        }
        composable(AppDestination.Profile.route) {
            ProfileScreen()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview3() {
    JogoForcaTheme {

    }
}