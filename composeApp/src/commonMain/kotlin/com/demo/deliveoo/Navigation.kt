package com.demo.deliveoo

// Navigation.kt
import androidx.compose.runtime.Composable
import moe.tlaster.precompose.navigation.NavHost
import moe.tlaster.precompose.navigation.rememberNavigator

@Composable
fun AppNavigation() {
    val navigator = rememberNavigator()

    NavHost(
        navigator = navigator,
        initialRoute = "/splash"
    ) {
        scene("/splash") {
            SplashScreen(
                onSplashFinished = {
                    navigator.navigate("/home")
                }
            )
        }

        scene("/home") {
            HomeScreen(
                onRestaurantClick = { restaurantId ->
                    navigator.navigate("/restaurant/$restaurantId")
                }
            )
        }
        scene("/restaurant/{restaurantId}") { backStackEntry ->
            val restaurantId = backStackEntry.path.substringAfter("restaurant/")
            RestaurantMenuScreen(
                restaurantName = restaurantId,
                onBackClick = {
                    navigator.popBackStack()
                }
            )
        }

    }
}