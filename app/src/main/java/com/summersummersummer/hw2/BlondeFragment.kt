package com.summersummersummer.hw2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import com.summersummersummer.R
import com.summersummersummer.databinding.FragmentBlondeBinding

class BlondeFragment : Fragment(R.layout.fragment_blonde) {
    private var binding: FragmentBlondeBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentBlondeBinding.bind(view)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}