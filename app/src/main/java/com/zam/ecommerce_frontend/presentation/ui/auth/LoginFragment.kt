package com.zam.ecommerce_frontend.presentation.ui.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.zam.ecommerce_frontend.R
import com.zam.ecommerce_frontend.databinding.FragmentLoginBinding
import com.zam.ecommerce_frontend.presentation.utils.Utils

class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding as FragmentLoginBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.fieldEmail.doAfterTextChanged {
            if(it != null){
                if(!Utils.isEmailValid(it)){
                    binding.layoutEmail.error = "Email Tidak Valid"
                }else{
                    binding.layoutEmail.isErrorEnabled = false
                }
            }
        }
        binding.fieldPassword.doAfterTextChanged {
            if(it != null){
                if(it.length < 8){
                    binding.layoutPassword.error = "Password Tidak Valid"
                }else{
                    binding.layoutPassword.isErrorEnabled = false
                }
            }
        }
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