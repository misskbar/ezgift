package com.example.ezgift.presentation

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.annotation.Nullable
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.fragment.app.FragmentManager
import androidx.navigation.compose.rememberNavController
import com.example.ezgift.presentation.navigation.AuthenticationNavGraph
import com.example.ezgift.presentation.navigation.EzGiftDestinations
import com.example.ezgift.presentation.navigation.EzGiftNavigationActions
import com.example.ezgift.presentation.ui.authenticate.ShowLottieAnimation
import com.example.ezgift.presentation.ui.theme.EzGiftTheme


@ExperimentalComposeUiApi
class AuthenticationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EzGiftTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    OnBoarding(supportFragmentManager = supportFragmentManager)
                }
            }
        }
    }
}

@ExperimentalComposeUiApi
@Composable
fun OnBoarding(@Nullable supportFragmentManager : FragmentManager?) {
    var shouldShowAnimation by rememberSaveable { mutableStateOf(true) }

    if (shouldShowAnimation) {
        ShowLottieAnimation(onAnimationFinished = { shouldShowAnimation = false })
    } else {
//        Init authentication nav graph
        AuthenticationNav(supportFragmentManager = supportFragmentManager)
    }
}

@ExperimentalComposeUiApi
@Composable
fun AuthenticationNav(@Nullable supportFragmentManager : FragmentManager?) {
    val navController = rememberNavController()
    val navigationActions = remember(navController) {
        EzGiftNavigationActions(
            navController
        )
    }
    Row(
        Modifier
            .fillMaxSize()
    ) {
        AuthenticationNavGraph(
            startDestination = EzGiftDestinations.WELCOME_ROUTE,
            navController = navController,
            navigationActions = navigationActions,
            supportFragmentManager = supportFragmentManager
        )
    }
}

@ExperimentalComposeUiApi
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    EzGiftTheme {
        OnBoarding(supportFragmentManager = null)
    }
}