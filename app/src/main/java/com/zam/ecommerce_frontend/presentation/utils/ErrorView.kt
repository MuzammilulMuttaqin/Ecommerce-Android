package com.zam.ecommerce_frontend.presentation.utils

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import androidx.core.view.isVisible
import com.zam.ecommerce_frontend.databinding.ErrorViewBinding

class ErrorView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) : LinearLayout(context, attrs, defStyleAttr) {
    private var binding: ErrorViewBinding

    init {
        binding = ErrorViewBinding.inflate(LayoutInflater.from(context), this, true)
    }

    fun setErrorMessage(title:String, description: String, btnTitle: String = "", action: () -> (Unit)) = with(binding) {
        tvErrorTitle.text = title
        tvErrorDescription.text = description
        btnRetry.isVisible = btnTitle.isNotEmpty()
        btnRetry.text = btnTitle
        btnRetry.setOnClickListener {
            action.invoke()
        }
    }
}