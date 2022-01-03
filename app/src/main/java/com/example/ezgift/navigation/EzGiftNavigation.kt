package com.example.ezgift.navigation

import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController


object EzGiftDestinations {
    const val WELCOME_ROUTE = "welcome"
    const val SIGN_UP_ROUTE = "signup"
    const val SIGN_IN_ROUTE = "signin"
    const val HOME_ROUTE = "home"
}

class EzGiftNavigationActions(navController: NavHostController) {

    val navigateToSignIn: () -> Unit = {
        navController.navigate(EzGiftDestinations.SIGN_IN_ROUTE) {
            popUpTo(navController.graph.findStartDestination().id) {
                saveState = true
            }
            launchSingleTop = true
            restoreState = true
        }
    }

    val navigateToSignUp: () -> Unit = {
        navController.navigate(EzGiftDestinations.SIGN_UP_ROUTE) {
            popUpTo(navController.graph.findStartDestination().id) {
                saveState = true
            }
            launchSingleTop = true
            restoreState = true
        }
    }

    val navigateToHome: () -> Unit = {
        navController.navigate(EzGiftDestinations.HOME_ROUTE) {
            popUpTo(0) {
                saveState = false
            }
            launchSingleTop = true
            restoreState = true
        }
    }
}