package com.zam.ecommerce_frontend.presentation.ui.onboarding

import android.animation.ObjectAnimator
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.zam.ecommerce_frontend.R
import com.zam.ecommerce_frontend.databinding.FragmentSplashBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class SplashFragment : Fragment() {
    private var _binding: FragmentSplashBinding? = null
    private val binding get() = _binding as FragmentSplashBinding
    private val viewModel : OnboardingViewModel by viewModel()
    private val rotate = View.ROTATION
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSplashBinding.inflate(inflater)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        animation()
        animation2()
        animation3()
        lifecycleScope.launch {
            delay(2000)
            navigateController()
        }
    }

    private fun animation(){
        ObjectAnimator.ofFloat(binding.cardRed, rotate,  30f).apply {
            duration = 2000
        }.start()
    }
    private fun animation2(){
        ObjectAnimator.ofFloat(binding.cardYellow, rotate, -30f).apply {
            duration = 2000
        }.start()
    }
    private fun animation3(){
        ObjectAnimator.ofFloat(binding.cardGreen, View.TRANSLATION_Y,  -200f).apply {
            duration = 2000
        }.start()
    }
    private fun navigateController(){
        viewModel.appOnboardingLiveData.observe(viewLifecycleOwner){ isActive ->
            when(isActive){
                true -> findNavController().navigate(R.id.action_splashFragment_to_loginFragment)
                else -> findNavController().navigate(R.id.action_splashFragment_to_onboardingFragment)
            }
        }
    }

}