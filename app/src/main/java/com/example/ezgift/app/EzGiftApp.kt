package com.example.ezgift.app

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.ezgift.navigation.EzGiftNavGraph
import com.example.ezgift.navigation.EzGiftNavigationActions
import com.example.ezgift.ui.theme.EzGiftTheme
import com.google.accompanist.insets.ProvideWindowInsets

@Composable
fun EzGiftApp() {
    EzGiftTheme {
        ProvideWindowInsets {
            val navController = rememberNavController()
            val navigationActions = remember(navController) {
                EzGiftNavigationActions(navController)
            }
            Row(
                Modifier
                    .fillMaxSize()
            ) {
                EzGiftNavGraph(
                    navController = navController,
                    navigationActions = navigationActions
                )
            }
        }
    }
}