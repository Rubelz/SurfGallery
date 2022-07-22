package com.example.surfgallery.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.surfgallery.R
import com.example.surfgallery.databinding.FragmentMainBinding
import com.example.surfgallery.ui.favs.FavouritesFragment
import com.example.surfgallery.ui.gallery.GalleryFragment
import com.example.surfgallery.ui.profile.ProfileFragment

class MainFragment : Fragment() {


    private lateinit var bind: FragmentMainBinding



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        bind = FragmentMainBinding.inflate(LayoutInflater.from(inflater.context), container, false)

        return bind.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navigateTo(GalleryFragment())
        bind.bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.gallery -> navigateTo(GalleryFragment())
                R.id.favourites -> navigateTo(FavouritesFragment())
                R.id.profile -> navigateTo(ProfileFragment())
            }
            true
        }


    }

    private fun navigateTo(fragment: Fragment) {
        childFragmentManager.beginTransaction()
            .replace(R.id.fragContainerMain, fragment)
            .commit()
    }

}