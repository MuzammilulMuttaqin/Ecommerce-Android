package com.zam.ecommerce_frontend.presentation.utils

import android.content.Context
import android.text.Editable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import androidx.core.content.ContextCompat
import com.zam.ecommerce_frontend.R
import java.util.regex.Matcher
import java.util.regex.Pattern

object Utils {
    fun isEmailValid(email: Editable): Boolean{
        val expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$"
        val pattern: Pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE)
        val matcher: Matcher = pattern.matcher(email)
        return matcher.matches()
    }
    fun customTextColor(context : Context, fullText : String): SpannableString {
        val spannableString = SpannableString(fullText)

        val validateFirstText = fullText.indexOf("Syarat & Ketentuan")
        val initFirstText = validateFirstText + "Syarat & Ketentuan".length

        val validateSechondText = fullText.indexOf("Kebijakan Privasi")
        val initSechondText = validateSechondText + "Kebijakan Privasi".length

        val customPurpleColor = ContextCompat.getColor(context, R.color.primary)
        spannableString.setSpan(
            ForegroundColorSpan(customPurpleColor),
            validateFirstText,
            initFirstText,
            0
        )
        spannableString.setSpan(
            ForegroundColorSpan(customPurpleColor),
            validateSechondText,
            initSechondText,
            0
        )

        return SpannableString(spannableString)
    }
}