package com.myapplication.app.utils

import android.util.Patterns

fun isStringEmpty(string: String?): Boolean {
    return string == null || string.length == 0
}

fun isStringValid(string: String?): Boolean {
    return string != null && string.length > 0
}

fun isEmailValid(email: String?): Boolean {
    return email != null && Patterns.EMAIL_ADDRESS.matcher(email).matches()
}

fun isPhoneValid(phone: String?): Boolean {
    return phone != null && phone.length == 8
}

fun isPasswordValid(password: String?): Boolean {
    return password != null && password.length > 5
}