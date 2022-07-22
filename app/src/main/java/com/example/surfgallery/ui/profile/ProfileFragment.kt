package com.example.surfgallery.ui.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.surfgallery.R
import com.example.surfgallery.data.models.User
import com.example.surfgallery.data.room.UserReciever
import com.example.surfgallery.data.room.UserViewModel
import com.example.surfgallery.databinding.FragmentProfileBinding
import com.example.surfgallery.ui.main.UserSender
import com.example.surfgallery.utils.SessionManager
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.*

class ProfileFragment : Fragment(), UserSender {

    private lateinit var bind: FragmentProfileBinding

    private val userVM: UserViewModel by viewModels()

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



        userVM.user.observe(viewLifecycleOwner, Observer { userInfo ->

            CoroutineScope(IO).launch {
                withContext(Main) {

                    Glide.with(requireContext())
                        .load(userInfo?.avatar)
                        .into(bind.imgAvatar)

                    bind.tvName.text = "${userInfo?.firstName}\n${userInfo?.lastName}"
                    bind.tvAbout.text = userInfo?.about
                    bind.tvCity.text = userInfo?.city
                    bind.tvPhone.text = userInfo?.phone
                    bind.tvEmail.text = userInfo?.email
                }
            }

        })

    }

    override fun sendUser(user: User?) {
        userVM.addUser(user)
    }
}