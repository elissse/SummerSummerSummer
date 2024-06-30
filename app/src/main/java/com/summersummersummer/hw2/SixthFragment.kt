package com.summersummersummer.hw2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import com.summersummersummer.R
import com.summersummersummer.databinding.FragmentSixthBinding

class SixthFragment : Fragment(R.layout.fragment_sixth) {
    private var binding: FragmentSixthBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSixthBinding.bind(view)
        val song = arguments?.getString(ARG_SONG) ?: "ERROR"
        binding?.run {
            tvTitle.text = "${tvTitle.text} : $song"
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    companion object {
        private const val ARG_SONG = "ARG_SONG"
        fun bundle(song: String): Bundle = Bundle().apply {
            putString(ARG_SONG, song)
        }
    }
}