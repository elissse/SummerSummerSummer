package com.summersummersummer.hw2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import com.summersummersummer.R
import com.summersummersummer.databinding.FragmentFlowerBoyBinding

class FlowerBoyFragment : Fragment(R.layout.fragment_flower_boy) {
    private var binding: FragmentFlowerBoyBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentFlowerBoyBinding.bind(view)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}