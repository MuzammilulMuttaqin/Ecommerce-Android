package com.zam.ecommerce_frontend.presentation.utils

import android.text.Editable
import android.text.SpannableString
import android.text.style.ClickableSpan
import android.text.style.ForegroundColorSpan
import android.view.View
import java.util.regex.Matcher
import java.util.regex.Pattern

object Utils {
    fun isEmailValid(email: Editable): Boolean{
        val expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$"
        val pattern: Pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE)
        val matcher: Matcher = pattern.matcher(email)
        return matcher.matches()
    }
    fun String.customTextColor(
        locale: String,
        color: Int,
        actionInc: () -> Unit,
        actionPolicy : () -> Unit): SpannableString {
        val spannableString = SpannableString(this)

        val tncText = if (locale =="in") "Syarat & Ketentuan" else "Terms & Conditions"
        val policyText = if (locale == "in") "Kebijakan Privasi" else "Privacy Policy"

        val startTnc = this.indexOf(tncText)
        val endTnc = startTnc + tncText.length

        val startPolicy = this.indexOf(policyText)
        val endPolicy = startPolicy + policyText.length

        val tncClickableSpan = object : ClickableSpan(){
            override fun onClick(widget: View) {
                actionInc.invoke()
            }
        }

        val policyClickableSpan = object :  ClickableSpan(){
            override fun onClick(widget: View) {
                actionPolicy.invoke()
            }
        }

        spannableString.setSpan(
            ForegroundColorSpan(color),
            startPolicy,
            endPolicy,
            0
        )
        spannableString.setSpan(
            ForegroundColorSpan(color),
            startTnc,
            endTnc,
            0
        )

        spannableString.setSpan(
            tncClickableSpan,
            startTnc,
            endTnc,
            0
        )
        spannableString.setSpan(
            policyClickableSpan,
            startPolicy,
            endPolicy,
            0
        )

        return SpannableString(spannableString)
    }
}