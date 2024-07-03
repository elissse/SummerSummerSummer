package com.summersummersummer.hw2

import android.content.Context
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.RequestManager
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.summersummersummer.R
import com.summersummersummer.databinding.ItemAlbumBinding

class AlbumHolder(
    private val binding: ItemAlbumBinding,
    private val glide: RequestManager,
    private val onClick: (Album) -> Unit,
) : ViewHolder(binding.root) {

    private val requestOptions = RequestOptions
        .diskCacheStrategyOf(
            DiskCacheStrategy.ALL
        )

    private val context: Context
        get() = itemView.context

    fun onBind(album: Album) {
        binding.run {
            tvName.text = album.name
            tvArtist.text = album.artist

            glide
                .load(album.url)
                .error(R.drawable.baseline_error_outline_24)
                .placeholder(R.drawable.baseline_grade_24)
                .apply(requestOptions)
                .into(ivImage)

            root.setOnClickListener {
                onClick.invoke(album)
            }

            tvName.setTextColor(context.getColor(album.getTitleColor()))
        }
    }

    private fun Album.getTitleColor(): Int = if (url.length > 120) {
        R.color.pink_700
    } else {
        R.color.pink_200
    }
}