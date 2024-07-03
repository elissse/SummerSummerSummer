package com.summersummersummer.hw2

import android.graphics.BitmapFactory
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.summersummersummer.R
import com.summersummersummer.databinding.FragmentAlbumBinding

class AlbumFragment : Fragment(R.layout.fragment_album) {
    private var binding: FragmentAlbumBinding? = null
    private val goBack: String = "https://vectorified.com/images/go-back-icon-31.png"

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentAlbumBinding.bind(view)
        val id = arguments?.getInt(ARG_ID) ?: "ERROR"
        val album = AlbumRepository.albums.find { it.id == id }
        if (album != null) {
            binding?.run {
                tvArtist.text = album.artist
                tvName.text = album.name
                context?.let {
                    Glide.with(it.applicationContext).asBitmap().load(album.url).into(ivImage)
                    Glide.with(it.applicationContext).asBitmap().load(goBack).into(ivBack)
                }
                tvInfo.text = album.info
                ivBack.setOnClickListener { view ->
                    view.findNavController().navigate(R.id.action_albumFragment_to_thirdFragment)
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    companion object {
        private const val ARG_ID = "ARG_ID"
        fun bundle(id: Int): Bundle = Bundle().apply {
            putInt(ARG_ID, id)
        }
    }
}