package com.example.ezgift.ui.authenticate

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ezgift.R
import com.example.ezgift.ui.theme.EzGiftTheme
import com.example.ezgift.ui.theme.Primary

@Composable
fun SignIn(onSignInClicked: () -> Unit) {

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {

        Text(
            text = "SIGN IN",
            color = Primary,
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp
        )

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {

            Image(
                modifier = Modifier
                    .size(50.dp)
                    .border(BorderStroke(1.dp, Color.Gray), CircleShape)
                    .padding(10.dp),
                painter = painterResource(R.drawable.ic_icon_facebook),
                contentDescription = "Twitter Icon",
            )
            Spacer(modifier = Modifier.width(10.dp))
            Image(
                modifier = Modifier
                    .size(50.dp)
                    .border(BorderStroke(1.dp, Color.Gray), CircleShape)
                    .padding(10.dp),
                painter = painterResource(R.drawable.ic_icon_twitter),
                contentDescription = "Twitter Icon",
            )
            Spacer(modifier = Modifier.width(10.dp))
            Image(
                modifier = Modifier
                    .size(50.dp)
                    .border(BorderStroke(1.dp, Color.Gray), CircleShape)
                    .padding(10.dp),
                painter = painterResource(R.drawable.ic_icon_google_plus),
                contentDescription = "Twitter Icon",
            )
        }

        Text(
            text = "or use your email account:",
            color = Color.DarkGray,
            fontWeight = FontWeight.Normal,
            fontSize = 15.sp
        )

        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            placeholder = { Text("Correo Electrónico") },
            label = { Text("Correo Electrónico") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
        )

        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            placeholder = { Text("Password") },
            label = { Text("Password") },
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
        )

        Text(
            text = "Forgot your password?",
            color = Color.DarkGray,
            textDecoration = TextDecoration.combine(
                listOf(
                    TextDecoration.Underline
                )
            ),
            fontWeight = FontWeight.Normal,
            fontSize = 15.sp
        )

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

@Preview(showBackground = true)
@Composable
fun SignInPreview() {
    EzGiftTheme {
        SignIn(onSignInClicked = {})
    }
}