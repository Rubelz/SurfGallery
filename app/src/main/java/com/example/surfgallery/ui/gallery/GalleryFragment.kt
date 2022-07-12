package com.example.surfgallery.ui.gallery

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Gallery
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.surfgallery.R
import com.example.surfgallery.databinding.FragmentGalleryBinding
import com.example.surfgallery.utils.Consts
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class GalleryFragment : Fragment() {

    private lateinit var bind: FragmentGalleryBinding

    private val viewModel: GalleryViewModel by viewModels()

    private lateinit var adapter: GalleryAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bind = FragmentGalleryBinding.inflate(
            LayoutInflater.from(inflater.context),
            container, false
        )

        return bind.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bind.rvGallery.layoutManager = GridLayoutManager(requireContext(), 2)

        viewModel.image.observe(viewLifecycleOwner, Observer {
            val pictures = it
            adapter = GalleryAdapter(pictures)
            bind.rvGallery.adapter = adapter
            adapter.refreshGallery(pictures)
        })

        val prefs = requireContext().getSharedPreferences(Consts.APP_PREF, Context.MODE_PRIVATE)
        val tokenPref = prefs.getString(Consts.PREFS_KEY_RETROFIT_1, null)
        CoroutineScope(IO).launch {
            viewModel.getPicture(tokenPref)
        }
    }

}