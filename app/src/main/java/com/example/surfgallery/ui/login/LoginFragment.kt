package com.example.surfgallery.ui.login

import android.content.Context
import android.os.Bundle
import android.telephony.PhoneNumberFormattingTextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.surfgallery.R
import com.example.surfgallery.databinding.FragmentLoginBinding
import com.example.surfgallery.utils.SessionManager
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class LoginFragment : Fragment() {

    private lateinit var bind: FragmentLoginBinding

    private val loginVM: LoginViewModel by viewModels()

    private lateinit var sessionManager: SessionManager


    override fun onAttach(context: Context) {
        super.onAttach(context)

        sessionManager = SessionManager(requireContext())
        CoroutineScope(IO).launch {
            loginVM.login(sessionManager)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        bind = FragmentLoginBinding.inflate(inflater)

        return bind.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        loginVM.loginResult.observe(viewLifecycleOwner, Observer { value ->
            sessionManager.saveToken(value)
            if (!value.isNullOrBlank()) {

                findNavController().navigate(R.id.loginToMain)


            }
        })


        loginVM.userResult.observe(viewLifecycleOwner, Observer { value ->


        })

        bind.etLogin.addTextChangedListener(object : PhoneNumberFormattingTextWatcher("RU") {})

        bind.btnLogin.setOnClickListener {
            if (bind.etPass.text.toString().isNotBlank() && bind.etLogin.text.toString()
                    .isNotBlank()
            ) {
                val phone = bind.etLogin.text.toString()
                val psswd = bind.etPass.text.toString()
                CoroutineScope(IO).launch {
                    loginVM.login(phone, psswd)
                }

            } else {
                // TODO: Add "No Credentials"
            }

        }

    }


}