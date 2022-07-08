package com.example.surfgallery.ui.login

import android.content.Context
import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.surfgallery.R
import com.example.surfgallery.databinding.FragmentLoginBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import java.util.*

class LoginFragment : Fragment() {

    private lateinit var bind: FragmentLoginBinding

    private val viewModel: LoginViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        bind = FragmentLoginBinding.inflate(inflater)

        return bind.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bind.btnLogin.setOnClickListener {
            if (bind.etPass.text.toString().isNotBlank() && bind.etLogin.text.toString()
                    .isNotBlank()
            ) {
                CoroutineScope(IO).launch {
                    viewModel.login(
                        bind.etLogin.text.toString(),
                        bind.etPass.text.toString()
                    )
                }
            }
        }
        viewModel.loginRequest.observe(viewLifecycleOwner) {
            if (it) findNavController().navigate(R.id.loginToMain)
            else Toast.makeText(
                requireContext(),
                "400: Wrong Login or Password",
                Toast.LENGTH_SHORT
            ).show()
        }
    }


}