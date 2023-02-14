package com.example.ezgift.presentation.ui.authenticate

import androidx.annotation.Nullable
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
import androidx.fragment.app.FragmentManager
import com.example.ezgift.R
import com.example.ezgift.presentation.ui.theme.ErrorMessage
import com.example.ezgift.presentation.ui.theme.EzGiftTheme
import com.example.ezgift.presentation.ui.theme.Primary
import com.example.ezgift.presentation.utils.*
import com.google.android.material.datepicker.CalendarConstraints
import com.google.android.material.datepicker.DateValidatorPointBackward
import com.google.android.material.datepicker.MaterialDatePicker
import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import java.util.*

@ExperimentalComposeUiApi
@Composable
fun SignUp(
    onSignUpClicked: () -> Unit,
    onSignInClicked: () -> Unit,
    @Nullable supportFragmentManager: FragmentManager?
) {

//    fields
    var firstName by remember { mutableStateOf(Const.EMPTY_STRING) }
    var lastName by remember { mutableStateOf(Const.EMPTY_STRING) }
    var email by remember { mutableStateOf(Const.EMPTY_STRING) }
    var date by remember { mutableStateOf(Const.EMPTY_STRING) }
    var password by remember { mutableStateOf(Const.EMPTY_STRING) }
    var passwordConfirmation by remember { mutableStateOf(Const.EMPTY_STRING) }

//    error messages
    var emailErrorMessage by remember { mutableStateOf(Const.EMPTY_STRING) }
    var lastNameErrorMessage by remember { mutableStateOf(Const.EMPTY_STRING) }
    var firstNameErrorMessage by remember { mutableStateOf(Const.EMPTY_STRING) }
    var passwordErrorMessage by remember { mutableStateOf(Const.EMPTY_STRING) }
    var passwordConfirmErrorMessage by remember { mutableStateOf(Const.EMPTY_STRING) }
    var dateErrorMessage by remember { mutableStateOf("Required field") }

//    validations
    var isFirstNameValid by remember { mutableStateOf(true) }
    var isLastNameValid by remember { mutableStateOf(true) }
    var isEmailValid by remember { mutableStateOf(true) }
    var isDateValid by remember { mutableStateOf(true) }
    var isPasswordVisible by remember { mutableStateOf(false) }
    var isPasswordConfirmVisible by remember { mutableStateOf(false) }
    var isPasswordValid by remember { mutableStateOf(true) }
    var arePasswordsValid by remember { mutableStateOf(true) }

//    ui controller
    val keyboardController = LocalSoftwareKeyboardController.current
    val scrollState = rememberScrollState()

//    firebase
    val isSocialAuthEnabled = FirebaseRemoteConfig.getInstance().getBoolean("social_auth_enabled")

    val constraintsBuilder =
        CalendarConstraints.Builder()
            .setValidator(DateValidatorPointBackward.now())

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
                    contentDescription = stringResource(R.string.icon_facebook_description),
                )
                Spacer(modifier = Modifier.width(10.dp))
                Image(
                    modifier = Modifier
                        .size(50.dp)
                        .border(BorderStroke(1.dp, Color.Gray), CircleShape)
                        .padding(10.dp),
                    painter = painterResource(R.drawable.ic_icon_twitter),
                    contentDescription = stringResource(R.string.icon_twitter_description),
                )
                Spacer(modifier = Modifier.width(10.dp))
                Image(
                    modifier = Modifier
                        .size(50.dp)
                        .border(BorderStroke(1.dp, Color.Gray), CircleShape)
                        .padding(10.dp),
                    painter = painterResource(R.drawable.ic_icon_google_plus),
                    contentDescription = stringResource(R.string.icon_googleplus_description),
                )
            }

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = stringResource(R.string.separator_social_manual_registration),
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
            contentDescription = stringResource(R.string.icon_user_avatar_description),
        )
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = firstName,
            onValueChange = {
                firstName = it
                isFirstNameValid = isNameValid(firstName) && firstName.isNotEmpty()
                firstNameErrorMessage = nameValidationError(firstName)
            },
            isError = !isFirstNameValid,
            singleLine = true,
            trailingIcon = {
                IconButton(onClick = { firstName = Const.EMPTY_STRING }) {
                    Icon(
                        imageVector = Icons.Filled.Clear,
                        contentDescription = Const.EMPTY_STRING
                    )
                }
            },
            placeholder = { Text(stringResource(R.string.placeholder_first_name)) },
            label = { Text(stringResource(R.string.label_first_name)) },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Next
            )
        )
        if (!isFirstNameValid) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 40.dp),
                horizontalArrangement = Arrangement.Start
            ) {
                Text(
                    text = firstNameErrorMessage,
                    color = ErrorMessage,
                    fontWeight = FontWeight.Bold,
                    fontSize = 10.sp
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = lastName,
            onValueChange = {
                lastName = it
                isLastNameValid = isNameValid(lastName) && lastName.isNotEmpty()
                lastNameErrorMessage = nameValidationError(lastName)
            },
            isError = !isLastNameValid,
            singleLine = true,
            trailingIcon = {
                IconButton(onClick = { lastName = Const.EMPTY_STRING }) {
                    Icon(
                        imageVector = Icons.Filled.Clear,
                        contentDescription = Const.EMPTY_STRING
                    )
                }
            },
            placeholder = { Text(stringResource(R.string.placeholder_last_name)) },
            label = { Text(stringResource(R.string.label_last_name)) },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Next
            )
        )
        if (!isLastNameValid) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 40.dp),
                horizontalArrangement = Arrangement.Start
            ) {
                Text(
                    text = lastNameErrorMessage,
                    color = ErrorMessage,
                    fontWeight = FontWeight.Bold,
                    fontSize = 10.sp
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = date,
            onValueChange = { date = it },
            singleLine = true,
            isError = !isDateValid,
            readOnly = true,
            trailingIcon = {
                IconButton(onClick = {
                    val picker = MaterialDatePicker.Builder.datePicker()
                        .setSelection(Date().time)
                        .setCalendarConstraints(constraintsBuilder.build())
                        .build()

                    supportFragmentManager?.let {
                        picker.show(it, picker.toString())
                        picker.addOnPositiveButtonClickListener {
                            date = dateToString(picker.selection)
                            isDateValid = true
                        }

                        picker.addOnNegativeButtonClickListener() {
                            date = Const.EMPTY_STRING
                            isDateValid = false
                        }
                    }

                }) {
                    Icon(
                        imageVector = Icons.Filled.CalendarToday,
                        contentDescription = Const.EMPTY_STRING
                    )
                }
            },
            placeholder = { Text("Date of Birth") },
            label = { Text("Date of Birth") }
        )
        if (!isDateValid) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 40.dp),
                horizontalArrangement = Arrangement.Start
            ) {
                Text(
                    text = dateErrorMessage,
                    color = ErrorMessage,
                    fontWeight = FontWeight.Bold,
                    fontSize = 10.sp
                )
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            isError = !isEmailValid,
            value = email,
            onValueChange = {
                email = it
                isEmailValid = isEmailValid(email) && email.isNotEmpty()
                emailErrorMessage = emailValidationError(email)
            },
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
                    .padding(start = 40.dp),
                horizontalArrangement = Arrangement.Start
            ) {
                Text(
                    text = emailErrorMessage,
                    color = ErrorMessage,
                    fontWeight = FontWeight.Bold,
                    fontSize = 10.sp
                )
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = password,
            onValueChange = {
                password = it
                isPasswordValid = isPasswordValid(password)
                passwordErrorMessage = passwordValidationError(password)
            },
            singleLine = true,
            isError = !isPasswordValid,
            trailingIcon = {
                IconButton(onClick = { isPasswordVisible = !isPasswordVisible }) {
                    Icon(
                        imageVector = if (isPasswordVisible) Icons.Default.Visibility else Icons.Default.VisibilityOff,
                        contentDescription = stringResource(R.string.icon_password_description)
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
        if (!isPasswordValid) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 40.dp),
                horizontalArrangement = Arrangement.Start
            ) {
                Text(
                    text = passwordErrorMessage,
                    color = ErrorMessage,
                    fontWeight = FontWeight.Bold,
                    fontSize = 10.sp
                )
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = passwordConfirmation,
            onValueChange = {
                passwordConfirmation = it
                arePasswordsValid = arePasswordsValid(password, passwordConfirmation)
                passwordConfirmErrorMessage =
                    passwordsValidationError(password, passwordConfirmation)
            },
            singleLine = true,
            isError = !arePasswordsValid,
            trailingIcon = {
                IconButton(onClick = { isPasswordConfirmVisible = !isPasswordConfirmVisible }) {
                    Icon(
                        imageVector = if (isPasswordConfirmVisible) Icons.Default.Visibility else Icons.Default.VisibilityOff,
                        contentDescription = stringResource(R.string.icon_password_description)
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
            placeholder = { Text(stringResource(R.string.placeholder_password_confirmation)) },
            label = { Text(stringResource(R.string.label_password_confirmation)) },
            visualTransformation = if (!isPasswordConfirmVisible) PasswordVisualTransformation() else VisualTransformation.None,
            keyboardOptions = KeyboardOptions(
                autoCorrect = false,
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Done
            )
        )
        if (!arePasswordsValid) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 40.dp),
                horizontalArrangement = Arrangement.Start
            ) {
                Text(
                    text = passwordConfirmErrorMessage,
                    color = ErrorMessage,
                    fontWeight = FontWeight.Bold,
                    fontSize = 10.sp
                )
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                modifier = Modifier.clickable(enabled = true, onClick = {
                    onSignUpClicked()
                }),
                text = stringResource(R.string.titile_already_have_an_account),
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
                text = stringResource(R.string.title_sign_in),
                color = Primary,
                fontWeight = FontWeight.Bold,
                fontSize = 15.sp
            )
        }

        Spacer(modifier = Modifier.height(20.dp))
        Button(
            enabled = (firstName.isNotEmpty()
                    && lastName.isNotEmpty()
                    && date.isNotEmpty()
                    && email.isNotEmpty() && isEmailValid
                    && password.isNotEmpty() && isPasswordValid
                    && passwordConfirmation.isNotEmpty() && arePasswordsValid
                    ),
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
                text = stringResource(R.string.title_sign_up_uppercase),
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
        SignUp(
            onSignUpClicked = {},
            onSignInClicked = {},
            supportFragmentManager = null
        )
    }
}