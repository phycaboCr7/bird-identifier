package com.birdidentifier.app.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.birdidentifier.app.ui.screens.home.HomeScreen
import com.birdidentifier.app.ui.screens.camera.CameraScreen
import com.birdidentifier.app.ui.screens.birddetails.BirdDetailsScreen
import com.birdidentifier.app.ui.screens.gallery.GalleryScreen

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object Camera : Screen("camera")
    object BirdDetails : Screen("bird_details/{birdId}") {
        fun createRoute(birdId: String) = "bird_details/$birdId"
    }
    object Gallery : Screen("gallery")
}

@Composable
fun AppNavigation(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {
        composable(Screen.Home.route) {
            HomeScreen(
                onCameraClick = { navController.navigate(Screen.Camera.route) },
                onGalleryClick = { navController.navigate(Screen.Gallery.route) },
                onBirdClick = { birdId -> 
                    navController.navigate(Screen.BirdDetails.createRoute(birdId))
                }
            )
        }
        
        composable(Screen.Camera.route) {
            CameraScreen(
                onNavigateBack = { navController.popBackStack() },
                onBirdIdentified = { birdId ->
                    navController.navigate(Screen.BirdDetails.createRoute(birdId)) {
                        popUpTo(Screen.Home.route)
                    }
                }
            )
        }
        
        composable(Screen.BirdDetails.route) { backStackEntry ->
            val birdId = backStackEntry.arguments?.getString("birdId") ?: return@composable
            BirdDetailsScreen(
                birdId = birdId,
                onNavigateBack = { navController.popBackStack() }
            )
        }
        
        composable(Screen.Gallery.route) {
            GalleryScreen(
                onNavigateBack = { navController.popBackStack() },
                onBirdClick = { birdId ->
                    navController.navigate(Screen.BirdDetails.createRoute(birdId))
                }
            )
        }
    }
} 