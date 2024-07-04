package com.summersummersummer.hw2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import com.summersummersummer.R
import com.summersummersummer.databinding.FragmentSaturationBinding

class SaturationFragment : Fragment(R.layout.fragment_saturation) {
    private var binding: FragmentSaturationBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSaturationBinding.bind(view)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}