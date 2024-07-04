package com.summersummersummer.hw2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import com.summersummersummer.R
import com.summersummersummer.databinding.FragmentIgorBinding

class IGORFragment : Fragment(R.layout.fragment_igor) {
    private var binding: FragmentIgorBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentIgorBinding.bind(view)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}