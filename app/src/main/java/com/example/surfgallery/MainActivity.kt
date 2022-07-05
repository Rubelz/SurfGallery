package com.example.surfgallery

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.surfgallery.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var bind: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bind.root)

        bind.toolBar.title = "Логин"
        setSupportActionBar(bind.toolBar)
    }
}