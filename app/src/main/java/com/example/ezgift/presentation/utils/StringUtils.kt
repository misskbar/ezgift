package com.example.ezgift.presentation.utils

import com.example.ezgift.presentation.utils.Const.simpleDateFormatPattern
import com.example.ezgift.presentation.utils.Regex.REGEX_EMAIL_VALIDATION
import java.text.SimpleDateFormat
import java.util.*
import java.util.regex.Pattern

object Const {
    const val EMPTY_STRING = ""
    const val SPACE = " "
    const val EMAIL_SEPARATOR = "@"
    const val simpleDateFormatPattern = "dd/MM/yyyy"
}

object Regex {
    const val REGEX_EMAIL_VALIDATION =
        "^((\"[\\w-\\s]+\")|([\\w-]+(?:\\.[\\w-]+)*)|(\"[\\w-\\s]+\")([\\w-]+(?:\\.[\\w-]+)*))(@((?:[\\w-]+\\.)*\\w[\\w-]{0,66})\\.([a-z]{2,7}(?:\\.[a-z]{2})?)$)|(@\\[?((25[0-5]\\.|2[0-4][0-9]\\.|1[0-9]{2}\\.|[0-9]{1,2}\\.))((25[0-5]|2[0-4][0-9]|1[0-9]{2}|[0-9]{1,2})\\.){2}(25[0-5]|2[0-4][0-9]|1[0-9]{2}|[0-9]{1,2})\\]?$)"
}

fun emailValidationError(email: String): String {
    if (email.isEmpty())
        return "Field is empty"
    return "Invalid email"
}

fun passwordValidationError(password: String): String {
    if (password.isEmpty())
        return "Field is empty"
    else if (password.length < 8)
        return "Minimun 8 characters"

    return "Invalid password"
}

fun isEmailValid(email: String): Boolean {
    return Pattern.matches(REGEX_EMAIL_VALIDATION, email)
}

fun isPasswordValid(password: String): Boolean {
    return password.length >= 8
}

fun arePasswordsValid(password: String, confirm: String): Boolean {
    return password == confirm
}

fun passwordsValidationError(password: String, confirm: String): String {
    if (password != confirm)
        return "Password do not match"

    return "Invalid password"
}

fun requiredFieldValidation(field: String): String {
    if (field.isEmpty())
        return "Required field"

    return Const.EMPTY_STRING
}

fun dateToString(date: Long?): String {
    date?.let {
        val sdf = SimpleDateFormat(simpleDateFormatPattern)
        sdf.timeZone = TimeZone.getTimeZone("GMT")
        return sdf.format(date)
    }

    return Const.EMPTY_STRING
}