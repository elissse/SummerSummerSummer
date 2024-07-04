package com.summersummersummer.hw2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import com.summersummersummer.R
import com.summersummersummer.databinding.FramentMmtbsBinding

class MMTBSFragment : Fragment(R.layout.frament_mmtbs) {
    private var binding: FramentMmtbsBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FramentMmtbsBinding.bind(view)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}