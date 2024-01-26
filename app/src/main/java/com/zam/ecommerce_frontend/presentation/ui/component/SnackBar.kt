package com.zam.ecommerce_frontend.presentation.ui.component

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.FrameLayout
import androidx.core.view.isVisible
import com.google.android.material.snackbar.BaseTransientBottomBar
import com.google.android.material.snackbar.Snackbar
import com.zam.ecommerce_frontend.R
import com.zam.ecommerce_frontend.databinding.LayoutSuccessBinding

object SnackBar {
//    companion object {
//        private const val SUCCESS = 200
//        private const val INFO = 300
//        private const val WARNING = 400
//        private const val ERROR = 500
//        private const val NETWORKERROR = 600
//      }

    @SuppressLint("RestrictedApi")
        fun createSnackbar(
            context: Context,
            view: View,
            text: String,
            action: ()-> Unit
        ) {
            val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            val binding = LayoutSuccessBinding.inflate(inflater)
            val snackBar = Snackbar.make(view, "", Snackbar.LENGTH_INDEFINITE)

            val snackBarLayout = snackBar.view as Snackbar.SnackbarLayout
            binding.messageView.text = text
        snackBarLayout.apply {
                val layoutParam = layoutParams as FrameLayout.LayoutParams
                layoutParam.gravity = Gravity.TOP
                layoutParams = layoutParam
            }
        snackBarLayout.addView(binding.root)

            snackBar.apply {
                view.setBackgroundColor(Color.TRANSPARENT)
                animationMode = BaseTransientBottomBar.ANIMATION_MODE_FADE
                val slideDownAnim = AnimationUtils.loadAnimation(context, R.anim.slide_down)
                val slideUpAnim = AnimationUtils.loadAnimation(context, R.anim.slide_up)
                view.startAnimation(slideDownAnim)
                slideDownAnim.setAnimationListener(object : Animation.AnimationListener {
                    override fun onAnimationStart(animation: Animation?) {
                    }

                    override fun onAnimationEnd(animation: Animation?) {
                        view.startAnimation(slideUpAnim)
                    }

                    override fun onAnimationRepeat(animation: Animation?) {
                    }

                })
                slideUpAnim.setAnimationListener(object : Animation.AnimationListener {
                    override fun onAnimationStart(animation: Animation?) {
                    }

                    override fun onAnimationEnd(animation: Animation?) {
                        view.isVisible = false
                        action.invoke()
                        dismiss()

                    }

                    override fun onAnimationRepeat(animation: Animation?) {
                    }

                })
                show()
            }
        }
}
