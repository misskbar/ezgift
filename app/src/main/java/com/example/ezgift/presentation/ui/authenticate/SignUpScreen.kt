package com.example.ezgift.presentation.ui.authenticate

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ezgift.R
import com.example.ezgift.presentation.ui.theme.EzGiftTheme
import com.example.ezgift.presentation.ui.theme.Primary
import com.example.ezgift.presentation.utils.Const
import com.google.android.material.datepicker.MaterialDatePicker
import com.google.firebase.remoteconfig.FirebaseRemoteConfig

@ExperimentalComposeUiApi
@Composable
fun SignUp(onSignUpClicked: () -> Unit, onSignInClicked: () -> Unit) {

    var firstName by remember { mutableStateOf(Const.EMPTY_STRING) }
    var lastName by remember { mutableStateOf(Const.EMPTY_STRING) }
    var email by remember { mutableStateOf(Const.EMPTY_STRING) }
    var date by remember { mutableStateOf(Const.EMPTY_STRING) }
    var password by remember { mutableStateOf(Const.EMPTY_STRING) }
    var isPasswordVisible by remember { mutableStateOf(false) }
    val keyboardController = LocalSoftwareKeyboardController.current
    val scrollState = rememberScrollState()
    val isSocialAuthEnabled = FirebaseRemoteConfig.getInstance().getBoolean("social_auth_enabled")


    val datePicker =
        MaterialDatePicker.Builder.datePicker()
            .setTitleText("Select date")
            .build()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(modifier = Modifier.height(50.dp))

        Text(
            text = stringResource(R.string.screen_title_sign_up),
            color = Primary,
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp
        )

        Spacer(modifier = Modifier.height(50.dp))

        if (isSocialAuthEnabled) {
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
                    contentDescription = "Facebook Icon",
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
                    contentDescription = "Google+ Icon",
                )
            }

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = "-------- or --------",
                color = Color.DarkGray,
                fontWeight = FontWeight.Normal,
                fontSize = 15.sp
            )
        }
        Spacer(modifier = Modifier.height(12.dp))

        Image(
            modifier = Modifier
                .size(100.dp)
                .border(BorderStroke(1.dp, Color.LightGray), CircleShape)
                .padding(30.dp),
            painter = painterResource(R.drawable.ic_icon_user_avatar),
            contentDescription = "User Avatar",
        )

        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(
            value = firstName,
            onValueChange = { firstName = it },
            singleLine = true,
            trailingIcon = {
                IconButton(onClick = { firstName = Const.EMPTY_STRING }) {
                    Icon(
                        imageVector = Icons.Filled.Clear,
                        contentDescription = Const.EMPTY_STRING
                    )
                }
            },
            placeholder = { Text("First Name") },
            label = { Text("First Name") },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Next
            )
        )

        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(
            value = lastName,
            onValueChange = { lastName = it },
            singleLine = true,
            trailingIcon = {
                IconButton(onClick = { lastName = Const.EMPTY_STRING }) {
                    Icon(
                        imageVector = Icons.Filled.Clear,
                        contentDescription = Const.EMPTY_STRING
                    )
                }
            },
            placeholder = { Text("Last Name") },
            label = { Text("Last Name") },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Next
            )
        )
        Spacer(modifier = Modifier.height(10.dp))
        OutlinedTextField(
            value = date,
            readOnly = true,
            onValueChange = { date = it },
            singleLine = true,
            trailingIcon = {
                IconButton(onClick = { }) {
                    Icon(
                        imageVector = Icons.Filled.CalendarToday,
                        contentDescription = Const.EMPTY_STRING
                    )
                }
            },
            placeholder = { Text("Date of Birth") },
            label = { Text("Date of Birth") }
        )
        Spacer(modifier = Modifier.height(10.dp))
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            singleLine = true,
            trailingIcon = {
                IconButton(onClick = { email = Const.EMPTY_STRING }) {
                    Icon(
                        imageVector = Icons.Filled.Clear,
                        contentDescription = Const.EMPTY_STRING
                    )
                }
            },
            placeholder = { Text(stringResource(R.string.placeholder_email)) },
            label = { Text(stringResource(R.string.label_email)) },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Next
            )
        )
        Spacer(modifier = Modifier.height(10.dp))
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            singleLine = true,
            trailingIcon = {
                IconButton(onClick = { isPasswordVisible = !isPasswordVisible }) {
                    Icon(
                        imageVector = if (isPasswordVisible) Icons.Default.Visibility else Icons.Default.VisibilityOff,
                        contentDescription = "Password Toggle"
                    )
                }
            },
            keyboardActions = KeyboardActions(
                onDone = {
                    keyboardController.let {
                        it?.hide()
                    }
                }
            ),
            placeholder = { Text(stringResource(R.string.placeholder_password)) },
            label = { Text(stringResource(R.string.label_password)) },
            visualTransformation = if (!isPasswordVisible) PasswordVisualTransformation() else VisualTransformation.None,
            keyboardOptions = KeyboardOptions(
                autoCorrect = false,
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Done
            )
        )
        Spacer(modifier = Modifier.height(20.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {

            Text(
                modifier = Modifier.clickable(enabled = true, onClick = {
                    onSignUpClicked()
                }),
                text = "Already have an account?",
                color = Color.DarkGray,
                textDecoration = TextDecoration.combine(
                    listOf(
                        TextDecoration.Underline
                    )
                ),
                fontWeight = FontWeight.Normal,
                fontSize = 15.sp
            )

            Spacer(modifier = Modifier.width(10.dp))

            Text(
                modifier = Modifier.clickable(enabled = true, onClick = {
                    onSignInClicked()
                }),
                text = "Sign in",
                color = Primary,
                fontWeight = FontWeight.Bold,
                fontSize = 15.sp
            )
        }

        Spacer(modifier = Modifier.height(20.dp))
        Button(
            elevation = ButtonDefaults.elevation(),
            shape = CircleShape,
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
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 15.sp
            )
        }
        Spacer(modifier = Modifier.height(50.dp))
    }

}

@ExperimentalComposeUiApi
@Preview(showBackground = true)
@Composable
fun SignUpPreview() {
    EzGiftTheme {
        SignUp(onSignUpClicked = {}, onSignInClicked = {})
    }
}