package com.example.ezgift.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.ezgift.ui.authenticate.Authenticate
import com.example.ezgift.ui.authenticate.ShowLottieAnimation
import com.example.ezgift.ui.authenticate.SignIn
import com.example.ezgift.ui.authenticate.SignUp
import com.example.ezgift.ui.home.Home

@ExperimentalComposeUiApi
@Composable
fun AuthenticationNavGraph(
    navController: NavHostController = rememberNavController(),
    startDestination: String,
    navigationActions : EzGiftNavigationActions
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
    ) {
        composable(EzGiftDestinations.WELCOME_ROUTE) {
            Authenticate(
                onSignInClicked = { navigationActions.navigateToSignIn() },
                onSignUpClicked = { navigationActions.navigateToSignUp() }
            )
        }
        composable(EzGiftDestinations.SIGN_IN_ROUTE) {
            SignIn(onSignInClicked = { navigationActions.navigateToHome() })
        }

        composable(EzGiftDestinations.SIGN_UP_ROUTE) {
            SignUp(onSignUpClicked = { navigationActions.navigateToHome() })
        }
        composable(EzGiftDestinations.HOME_ROUTE) {
            Home()
        }
    }

}