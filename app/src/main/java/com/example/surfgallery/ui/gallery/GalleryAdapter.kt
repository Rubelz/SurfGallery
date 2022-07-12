package com.example.surfgallery.ui.gallery

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.GlideBuilder
import com.example.surfgallery.data.models.Picture
import com.example.surfgallery.databinding.ItemGalleryBinding

class GalleryAdapter(
    private var imageList: List<Picture>,
    private val context: Context
) :
    RecyclerView.Adapter<GalleryAdapter.ImageHolder>() {


    fun refreshGallery(images: List<Picture>) {
        this.imageList = images
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageHolder {
        return ImageHolder(
            ItemGalleryBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ImageHolder, position: Int) {
        val url = imageList[position].photoUrl
        Glide.with(context)
            .load(url)
            .into(holder.bind.imgPicture)

        holder.bind.tvImgName.text = imageList[position].title
    }

    override fun getItemCount(): Int = imageList.size

    inner class ImageHolder(val bind: ItemGalleryBinding) : RecyclerView.ViewHolder(bind.root)
}