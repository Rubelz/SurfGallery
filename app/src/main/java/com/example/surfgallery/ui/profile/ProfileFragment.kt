package com.example.surfgallery.ui.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.surfgallery.R
import com.example.surfgallery.databinding.FragmentProfileBinding
import com.example.surfgallery.utils.SessionManager

class ProfileFragment : Fragment() {

    private lateinit var bind: FragmentProfileBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bind =
            FragmentProfileBinding.inflate(LayoutInflater.from(inflater.context), container, false)
        return bind.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val sessionManager = SessionManager(requireContext())

        bind.btnLogout.setOnClickListener {
            sessionManager.removeToken()
            findNavController().navigate(R.id.loginFragment)
        }
    }
}