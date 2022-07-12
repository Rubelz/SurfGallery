package com.example.surfgallery

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.replace
import androidx.navigation.NavHost
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.surfgallery.databinding.ActivityMainBinding
import com.example.surfgallery.ui.login.LoginFragment
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var bind: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bind.root)

        val navHostFrag =
            supportFragmentManager.findFragmentById(R.id.fragContainer) as NavHostFragment
        val navController = navHostFrag.navController

        navController.navigate(R.id.loginFragment)

    }


}