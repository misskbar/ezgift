package com.example.ezgift.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.ezgift.presentation.ui.authenticate.Authenticate
import com.example.ezgift.presentation.ui.authenticate.SignIn
import com.example.ezgift.presentation.ui.authenticate.SignUp
import com.example.ezgift.presentation.ui.home.Home

@ExperimentalComposeUiApi
@Composable
fun AuthenticationNavGraph(
    navController: NavHostController = rememberNavController(),
    startDestination: String,
    navigationActions: EzGiftNavigationActions
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
            SignIn(onSignInClicked = { navigationActions.navigateToHome() },
                onSignUpClicked = { navigationActions.navigateToSignUp },
                onForgotPwdClicked = {})
        }

        composable(EzGiftDestinations.SIGN_UP_ROUTE) {
            SignUp(onSignUpClicked = { navigationActions.navigateToHome() })
        }
        composable(EzGiftDestinations.HOME_ROUTE) {
            Home()
        }
    }

}