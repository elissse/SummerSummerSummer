package com.summersummersummer.day2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.findNavController
import com.summersummersummer.R
import com.summersummersummer.databinding.FragmentProfileBinding

class ProfileFragment : Fragment(R.layout.fragment_profile) {
    private var binding: FragmentProfileBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentProfileBinding.bind(view)
        val email = arguments?.getString(ARG_EMAIL) ?: "ERROR"
        binding?.run {
            tvTitle.text = "${tvTitle.text} : $email"
            tvTitle.setOnClickListener {
                findNavController().navigate(R.id.action_profileFragment_to_settingsFragment)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    companion object {
        private const val ARG_EMAIL = "ARG_EMAIL"
        private const val ARG_AGE = "ARG_AGE"
        fun bundle(email: String, age:Int): Bundle = Bundle().apply {
            putString(ARG_EMAIL, email)
            putInt(ARG_AGE, age)
        }
    }
}