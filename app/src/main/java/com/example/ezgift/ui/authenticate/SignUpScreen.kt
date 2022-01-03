package com.example.ezgift.ui.authenticate

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.ezgift.ui.theme.EzGiftTheme
import com.example.ezgift.ui.theme.Primary

@Composable
fun SignUp(onSignUpClicked: () -> Unit) {
    Text(
        text = "SIGN UP",
        color = Primary,
        fontWeight = FontWeight.Bold,
        fontSize = 50.sp
    )

}

@Preview(showBackground = true)
@Composable
fun SignUpPreview() {
    EzGiftTheme {
        SignUp(onSignUpClicked = {})
    }
}