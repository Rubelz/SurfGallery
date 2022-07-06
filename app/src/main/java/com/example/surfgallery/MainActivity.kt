package com.example.surfgallery

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.surfgallery.databinding.ActivityMainBinding
import com.example.surfgallery.ui.login.LoginFragment

class MainActivity : AppCompatActivity() {

    private lateinit var bind: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bind.root)



        val transact = supportFragmentManager.beginTransaction()
            .addToBackStack(null)
            .replace(R.id.fragContainer, LoginFragment())

        transact.commit()



    }


}