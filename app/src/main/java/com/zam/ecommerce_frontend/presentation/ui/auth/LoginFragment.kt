package com.zam.ecommerce_frontend.presentation.ui.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.zam.ecommerce_frontend.R
import com.zam.ecommerce_frontend.databinding.FragmentLoginBinding

/**
 * A simple [Fragment] subclass.
 * Use the [LoginFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding as FragmentLoginBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        val spannable = SpannableStringBuilder("Syarat & Ketentuan")
//        spannable.setSpan(
//            ForegroundColorSpan(resources.getColor(R.color.primary)),
//            0, // start
//            0, // end
//            Spannable.SPAN_EXCLUSIVE_INCLUSIVE
//        )
        binding.btnDaftar.setOnClickListener {
            view.findNavController().navigate(R.id.action_loginFragment_to_registerFragment2)
        }
        binding.btnMasuk.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_mainFragment)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater)
        return binding.root
    }

}