package com.zam.ecommerce_frontend

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.zam.ecommerce_frontend.databinding.FragmentOnboardingBinding

class OnboardingFragment : Fragment() {
    private var _binding: FragmentOnboardingBinding? = null
    private val binding get() = _binding as FragmentOnboardingBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentOnboardingBinding.inflate(inflater)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnLewati.setOnClickListener {
            view.findNavController().navigate(R.id.action_onboardingFragment_to_loginFragment)
        }

        binding.button.setOnClickListener {
            view.findNavController().navigate(R.id.action_onboardingFragment_to_registerFragment)
        }
    }
    private fun initView(){
        binding.apply {
            button.text = getString(R.string.gabung_sekarang)
            btnLewati.text = getString(R.string.lewati)
            btnSelanjutnya.text = getString(R.string.selanjutnya)
            imageView2.setImageResource(R.drawable.onboarding2)
            imageView3.setImageResource(R.drawable.onboarding3)
            imageFilterView8.setImageResource(R.drawable.intro_default)
            imageFilterView7.setImageResource(R.drawable.intro_default)
            imageFilterView9.setImageResource(R.drawable.intro_default)

        }
    }

}