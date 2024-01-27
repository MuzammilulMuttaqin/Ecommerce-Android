package com.zam.ecommerce_frontend.presentation.ui.auth

import android.content.Intent
import android.os.Bundle
import android.text.method.LinkMovementMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.net.toUri
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.zam.ecommerce_frontend.R
import com.zam.ecommerce_frontend.databinding.FragmentRegisterBinding
import com.zam.ecommerce_frontend.presentation.utils.Constant
import com.zam.ecommerce_frontend.presentation.utils.Utils
import com.zam.ecommerce_frontend.presentation.utils.Utils.customTextColor

class RegisterFragment : Fragment() {
    private var _binding: FragmentRegisterBinding? = null
    private val binding get() = _binding as FragmentRegisterBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        binding.btnMasuk.setOnClickListener {
            view.findNavController().navigate(R.id.action_registerFragment_to_loginFragment)
        }
        setTvPersyaratan()
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentRegisterBinding.inflate(inflater)
        return binding.root
    }
    private fun initView(){
        binding.apply {
            appbar.title = getString(R.string.daftar)
            fieldEmail.hint = getString(R.string.email)
            fieldPassword.hint = getString(R.string.password)
            layoutEmail.helperText = getString(R.string.helper_text_email)
            layoutPassword.helperText = getString(R.string.helper_text_password)
            btnDaftar.text = getString(R.string.daftar)
            tvAtau.text = getString(R.string.atau_masuk_dengan)
            btnMasuk.text = getString(R.string.masuk)

        }
    }
    private fun setTvPersyaratan(){
        with(binding) {

        }
        with(binding){
            tvPersyaratan.movementMethod = LinkMovementMethod.getInstance()
            val color = context?.let { ContextCompat.getColor(it, R.color.primary) }

            val actionInc : () -> Unit = {
                Intent(Intent.ACTION_VIEW, Constant.linkTvPersyaratan.toUri()).run {
                    context?.startActivity(this)
                }
            }
            val actionPolicy : () -> Unit = {
                Intent(Intent.ACTION_VIEW, Constant.linkTvPersyaratan.toUri()).run {
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

}