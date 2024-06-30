package com.summersummersummer.hw2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.summersummersummer.R
import com.summersummersummer.databinding.FragmentFirstBinding


class FirstFragment : Fragment(R.layout.fragment_first) {
    private var binding: FragmentFirstBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentFirstBinding.bind(view)
        binding?.run {
            tvTitle.setOnClickListener {
                val data = songEt.text.toString()
                if (data.isNotEmpty())
                    findNavController().navigate(
                        R.id.action_firstFragment_to_sixthFragment,
                        args = SixthFragment.bundle(
                            song = data
                        )
                    )
                else
                    Snackbar.make(
                        root,
                        "you have to listen to something",
                        Snackbar.LENGTH_SHORT
                    ).show()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}