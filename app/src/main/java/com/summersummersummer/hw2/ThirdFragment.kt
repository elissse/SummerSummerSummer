package com.summersummersummer.hw2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.google.android.material.snackbar.Snackbar
import com.summersummersummer.R
import com.summersummersummer.databinding.FragmentThirdBinding

class ThirdFragment : Fragment(R.layout.fragment_third) {
    private var binding: FragmentThirdBinding? = null
    private var adapter: AlbumAdapter? = null
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentThirdBinding.bind(view)
        initAdapter()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    private fun initAdapter() {
        binding?.run {
            adapter = AlbumAdapter(
                list = AlbumRepository.albums,
                glide = Glide.with(this@ThirdFragment),
                onClick = {
                    findNavController().navigate(
                        R.id.action_thirdFragment_to_albumFragment,
                        args = AlbumFragment.bundle(
                            id = it.id
                        )
                    )
                    // Snackbar.make(root, it.url, Snackbar.LENGTH_LONG).show()
                }
            )
            rvAlbum.adapter = adapter
            rvAlbum.layoutManager = LinearLayoutManager(requireContext())

        }
    }
}