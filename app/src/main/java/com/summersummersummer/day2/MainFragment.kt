package com.summersummersummer.day2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.findNavController
import com.summersummersummer.R
import com.summersummersummer.databinding.FragmentMainBinding


class MainFragment : Fragment(R.layout.fragment_main) {
    private var binding: FragmentMainBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMainBinding.bind(view)
        binding?.run {
            tvTitle.setOnClickListener {
//                val text = emailEt.text.toString()
//                val bundle = Bundle()
//                bundle.putString("ARG_EMAIL",text)
                findNavController().navigate(
                    R.id.action_mainFragment_to_profileFragment,
                    args = ProfileFragment.bundle(
                        email = emailEt.text.toString(),
                        age = 21
                    )
                )
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}