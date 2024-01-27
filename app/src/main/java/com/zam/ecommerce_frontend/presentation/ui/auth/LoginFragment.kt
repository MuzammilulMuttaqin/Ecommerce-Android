package com.zam.ecommerce_frontend.presentation.ui.auth

import android.content.Intent
import android.os.Bundle
import android.text.method.LinkMovementMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.net.toUri
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.zam.ecommerce_frontend.R
import com.zam.ecommerce_frontend.databinding.FragmentLoginBinding
import com.zam.ecommerce_frontend.presentation.ui.component.SnackBar
import com.zam.ecommerce_frontend.presentation.utils.Constant.linkTvPersyaratan
import com.zam.ecommerce_frontend.presentation.utils.Utils
import com.zam.ecommerce_frontend.presentation.utils.Utils.customTextColor

class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding as FragmentLoginBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        binding.fieldEmail.doAfterTextChanged {
            if(it != null){
                if(!Utils.isEmailValid(it)){
                    binding.layoutEmail.error = getString(R.string.email_tidak_valid)
                }else{
                    binding.layoutEmail.isErrorEnabled = false
                }
            }
        }
        binding.fieldPassword.doAfterTextChanged {
            if(it != null){
                if(it.length < 8){
                    binding.layoutPassword.error = getString(R.string.password_tidak_valid)
                }else{
                    binding.layoutPassword.isErrorEnabled = false
                }
            }
        }
        binding.btnDaftar.setOnClickListener {
            view.findNavController().navigate(R.id.action_loginFragment_to_registerFragment2)
        }

        setTvPersyaratan()
        binding.btnMasuk.setOnClickListener {
            SnackBar.createSnackBar(
                requireContext(),
                binding.root,
                getString(R.string.selesai)
            )
            {
                findNavController().navigate(R.id.action_loginFragment_to_mainFragment)
            }
        }


    }

    private fun initView(){
        binding.apply {
            appbar.title = getString(R.string.appbar_masuk)
            fieldEmail.hint = getString(R.string.email)
            fieldPassword.hint = getString(R.string.password)
            layoutEmail.helperText = getString(R.string.helper_text_email)
            layoutPassword.helperText = getString(R.string.helper_text_password)
            btnMasuk.text = getString(R.string.masuk)
            tvAtau.text = getString(R.string.atau_masuk_dengan)
            btnDaftar.text = getString(R.string.daftar)
        }
    }

    private fun setTvPersyaratan(){
        with(binding) {

        }
        with(binding){
            tvPersyaratan.movementMethod = LinkMovementMethod.getInstance()
            val color = context?.let { ContextCompat.getColor(it, R.color.primary) }

            val actionInc : () -> Unit = {
                Intent(Intent.ACTION_VIEW, linkTvPersyaratan.toUri()).run {
                    context?.startActivity(this)
                }
            }
            val actionPolicy : () -> Unit = {
                Intent(Intent.ACTION_VIEW,linkTvPersyaratan.toUri()).run {
                    context?.startActivity(this)
                }
            }

            if (color != null){
                tvPersyaratan.text = getString(R.string.SnK).customTextColor(
                    resources.configuration.locales[0].language,
                    color,
                    actionInc,
                    actionPolicy
                )
            }
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