package com.example.surfgallery.ui.login

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.surfgallery.R
import com.example.surfgallery.data.Retrofit
import com.example.surfgallery.data.api.UserService
import com.example.surfgallery.data.requests.LoginRequest
import com.example.surfgallery.databinding.FragmentLoginBinding
import com.example.surfgallery.utils.Consts
import com.example.surfgallery.utils.SessionManager
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class LoginFragment : Fragment() {

    private lateinit var bind: FragmentLoginBinding

    private val loginVM: LoginViewModel by viewModels()

    private lateinit var sessionManager: SessionManager

    override fun onAttach(context: Context) {
        super.onAttach(context)

        sessionManager = SessionManager(requireContext())
        val token = sessionManager.fetchToken()
        if(!token.isNullOrBlank()){
            findNavController().navigate(R.id.loginToMain)
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
            if (value != null) {
                findNavController().navigate(R.id.loginToMain)
            }
        })

        bind.btnLogin.setOnClickListener {
            if (bind.etPass.text.toString().isNotBlank() && bind.etLogin.text.toString()
                    .isNotBlank()
            ) {
//                val retrofit = Retrofit.getInstance().create(UserService::class.java)
                val phone = bind.etLogin.text.toString()
                val psswd = bind.etPass.text.toString()
                CoroutineScope(IO).launch {
//                    val response = retrofit.login(LoginRequest(phone, psswd)).body()
                    loginVM.login(phone, psswd)
                }

            } else {
                // TODO: Add "No Credentials"
            }

        }
    }

}