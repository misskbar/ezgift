package com.example.ezgift.presentation.ui.authenticate

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.ezgift.R
import com.example.ezgift.presentation.ui.theme.EzGiftTheme
import com.example.ezgift.presentation.ui.theme.Primary

@Composable
fun Authenticate(onSignInClicked: () -> Unit, onSignUpClicked: () -> Unit) {

    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.gift))

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Color.White
//                brush = Brush.linearGradient(
//                    colors = listOf(
//                        Primary,
//                        Secondary
//                    )
//                )
            )
    ) {


        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(vertical = 30.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            LottieAnimation(
                composition = composition,
                progress = 1.0f
            )
        }

        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 50.dp),
            textAlign = TextAlign.Center,
            text = "WELCOME",
            color = Color.White,
            fontWeight = FontWeight.Bold,
            letterSpacing = 10.sp,
            fontSize = 40.sp
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(vertical = 50.dp),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            Button(
                border = BorderStroke(width = 1.dp, color = Color.LightGray),
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
                shape = CircleShape,
                elevation = ButtonDefaults.elevation(),
                onClick = { onSignUpClicked() },
                contentPadding = PaddingValues(
                    start = 100.dp,
                    top = 20.dp,
                    end = 100.dp,
                    bottom = 20.dp
                )
            ) {
                Text(
                    text = "SIGN UP",
                    color = Primary,
                    fontWeight = FontWeight.Bold,
                    fontSize = 15.sp
                )
            }
            Spacer(modifier = Modifier.height(20.dp))
            Button(
                elevation = ButtonDefaults.elevation(),
                shape = CircleShape,
                onClick = { onSignInClicked() },
                contentPadding = PaddingValues(
                    start = 100.dp,
                    top = 20.dp,
                    end = 100.dp,
                    bottom = 20.dp
                )
            ) {
                Text(
                    text = "SIGN IN",
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 15.sp
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AuthenticatePreview() {
    EzGiftTheme {
        Authenticate(onSignUpClicked = {}, onSignInClicked = {})
    }
}