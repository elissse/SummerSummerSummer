package com.summersummersummer.hw2

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import com.summersummersummer.databinding.ItemAlbumBinding

class AlbumAdapter(
    private var list: List<Album>,
    private val glide: RequestManager,
    private val onClick: (Album) -> Unit,
) : RecyclerView.Adapter<AlbumHolder>() {


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AlbumHolder = AlbumHolder(
        binding = ItemAlbumBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ),
        glide = glide,
        onClick = onClick,
    )

    override fun onBindViewHolder(holder: AlbumHolder, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int = list.size
}