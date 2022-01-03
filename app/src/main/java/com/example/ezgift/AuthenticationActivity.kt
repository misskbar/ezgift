package com.example.ezgift

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import com.example.ezgift.app.EzGiftApp
import com.example.ezgift.ui.authenticate.ShowLottieAnimation
import com.example.ezgift.ui.theme.EzGiftTheme

class AuthenticationActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EzGiftTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    OnBoarding()
                }
            }
        }
    }
}

@Composable
fun OnBoarding() {
    var shouldShowAnimation by rememberSaveable { mutableStateOf(true) }
    var isUserLogged by rememberSaveable { mutableStateOf(false) }

    if (shouldShowAnimation) {
        ShowLottieAnimation(onAnimationFinished = { shouldShowAnimation = false })
    } else {
//        Init nav graph
        EzGiftApp()
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    EzGiftTheme {
        OnBoarding()
    }
}