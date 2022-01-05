package com.example.ezgift.presentation.utils

import com.example.ezgift.presentation.utils.Regex.REGEX_EMAIL_VALIDATION
import java.util.regex.Pattern

object Const {
    const val EMPTY_STRING = ""
    const val SPACE = " "
    const val EMAIL_SEPARATOR = "@"
}

object Regex {
    const val REGEX_EMAIL_VALIDATION = "^((\"[\\w-\\s]+\")|([\\w-]+(?:\\.[\\w-]+)*)|(\"[\\w-\\s]+\")([\\w-]+(?:\\.[\\w-]+)*))(@((?:[\\w-]+\\.)*\\w[\\w-]{0,66})\\.([a-z]{2,7}(?:\\.[a-z]{2})?)$)|(@\\[?((25[0-5]\\.|2[0-4][0-9]\\.|1[0-9]{2}\\.|[0-9]{1,2}\\.))((25[0-5]|2[0-4][0-9]|1[0-9]{2}|[0-9]{1,2})\\.){2}(25[0-5]|2[0-4][0-9]|1[0-9]{2}|[0-9]{1,2})\\]?$)"
}

fun emailValidationError(email: String): String {
    if(email.isEmpty())
        return "Field is empty"
    return "Invalid email"
}

fun isEmailValid(email: String): Boolean {
    return Pattern.matches(REGEX_EMAIL_VALIDATION, email)
}