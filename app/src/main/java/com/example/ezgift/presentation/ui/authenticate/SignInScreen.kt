package com.example.ezgift.presentation.ui.authenticate

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
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
import com.example.ezgift.presentation.utils.emailValidationError
import com.example.ezgift.presentation.utils.isEmailValid
import com.google.firebase.remoteconfig.FirebaseRemoteConfig

@ExperimentalComposeUiApi
@Composable
fun SignIn(
    onSignInClicked: () -> Unit,
    onForgotPwdClicked: () -> Unit,
    onSignUpClicked: () -> Unit
) {

    var email by remember { mutableStateOf(Const.EMPTY_STRING) }
    var isEmailValid by remember { mutableStateOf(true) }
    var emailErrorMessage by remember { mutableStateOf(Const.EMPTY_STRING) }
    var password by remember { mutableStateOf(Const.EMPTY_STRING) }
    var isPasswordVisible by remember { mutableStateOf(false) }
    val keyboardController = LocalSoftwareKeyboardController.current
    val isSocialAuthEnabled = FirebaseRemoteConfig.getInstance().getBoolean("social_auth_enabled")
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .background(Primary),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Image(
            contentDescription = "App Logo",
            painter = painterResource(id = R.drawable.ic_image_white_gift),
            modifier = Modifier
                .weight(1f)
        )

        Card(
            modifier = Modifier
                .weight(2f),
            shape = RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp)
        ) {

            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceEvenly
            ) {

                Text(modifier = Modifier.padding(vertical = 16.dp),
                    text = stringResource(R.string.screen_title_sign_in),
                    color = Primary,
                    fontWeight = FontWeight.Bold,
                    fontSize = 30.sp
                )

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

                    Text(
                        modifier = Modifier.padding(vertical = 8.dp),
                        text = stringResource(R.string.title_manual_registration),
                        color = Color.DarkGray,
                        fontWeight = FontWeight.Normal,
                        fontSize = 15.sp
                    )
                }
                OutlinedTextField(
                    modifier = Modifier.onFocusChanged {
                        if (!it.isFocused && email.isNotEmpty()) {
                            isEmailValid = isEmailValid(email) && email.isNotEmpty()
                            emailErrorMessage = emailValidationError(email)
                        }
                    },
                    isError = !isEmailValid,
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

                if (!isEmailValid) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 40.dp, bottom = 16.dp),
                        horizontalArrangement = Arrangement.Start
                    ) {
                        Text(
                            modifier = Modifier.clickable(enabled = true, onClick = {
                                onSignUpClicked()
                            }),
                            text = emailErrorMessage,
                            color = Color.Red,
                            fontWeight = FontWeight.Bold,
                            fontSize = 10.sp
                        )
                    }
                }

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

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp, bottom = 16.dp),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Text(
                        modifier = Modifier.clickable(enabled = true, onClick = {
                            onSignUpClicked()
                        }),
                        text = "Sign Up",
                        color = Primary,
                        fontWeight = FontWeight.Bold,
                        fontSize = 15.sp
                    )

                    Text(
                        modifier = Modifier.clickable(enabled = true, onClick = {
                            onForgotPwdClicked()
                        }),
                        text = stringResource(R.string.title_forgot_your_password),
                        color = Color.DarkGray,
                        textDecoration = TextDecoration.combine(
                            listOf(
                                TextDecoration.Underline
                            )
                        ),
                        fontWeight = FontWeight.Normal,
                        fontSize = 15.sp
                    )
                }

                Button(modifier = Modifier.padding(bottom = 24.dp),
                    elevation = ButtonDefaults.elevation(),
                    shape = CircleShape,
                    enabled = (email.isNotEmpty() && password.isNotEmpty() && isEmailValid),
                    onClick = { onSignInClicked() },
                    contentPadding = PaddingValues(
                        start = 100.dp,
                        top = 20.dp,
                        end = 100.dp,
                        bottom = 20.dp
                    )
                ) {
                    Text(
                        text = stringResource(R.string.button_title_sign_in),
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontSize = 15.sp
                    )
                }
            }
        }
    }
}

@ExperimentalComposeUiApi
@Preview(showBackground = true)
@Composable
fun SignInPreview() {
    EzGiftTheme {
        SignIn(onSignInClicked = {}, onForgotPwdClicked = {}, onSignUpClicked = {})
    }
}