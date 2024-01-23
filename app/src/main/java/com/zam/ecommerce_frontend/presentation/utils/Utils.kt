package com.zam.ecommerce_frontend.presentation.utils

import android.text.Editable
import java.util.regex.Matcher
import java.util.regex.Pattern

object Utils {
    fun isEmailValid(email: Editable): Boolean{
        val expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$"
        val pattern: Pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE)
        val matcher: Matcher = pattern.matcher(email)
        return matcher.matches()
    }
}