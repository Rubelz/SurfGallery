package com.example.surfgallery.ui.gallery

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.surfgallery.R
import com.example.surfgallery.databinding.FragmentGalleryBinding

class GalleryFragment : Fragment() {

    private lateinit var bind: FragmentGalleryBinding

    private lateinit var viewModel: GalleryViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bind =
            FragmentGalleryBinding.inflate(
                LayoutInflater.from(inflater.context),
                container, false
            )
        return bind.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

}