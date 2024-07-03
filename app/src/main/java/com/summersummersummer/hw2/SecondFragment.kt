package com.summersummersummer.hw2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.google.android.material.snackbar.Snackbar
import com.summersummersummer.R
import com.summersummersummer.databinding.FragmentSecondBinding

class SecondFragment : Fragment(R.layout.fragment_second) {
    private var binding: FragmentSecondBinding? = null
    private var adapter: CityAdapter? = null
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSecondBinding.bind(view)
        initAdapter()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    private fun initAdapter() {
        binding?.run {
            adapter = CityAdapter(
                list = CityRepository.cities,
                glide = Glide.with(this@SecondFragment),
                onClick = {

                   // root.showSnackbar(it.url, duration = Snackbar.LENGTH_LONG)

                    Snackbar.make(root, it.url, Snackbar.LENGTH_LONG).show()
                }
            )

            rvCity.adapter = adapter

//          по-умолчанию линерлайоутманагер строит вертикальный список
            rvCity.layoutManager = LinearLayoutManager(requireContext())
//            rvCity.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
//            rvCity.layoutManager = GridLayoutManager(requireContext(), 2)

            tvTitle.setOnClickListener {
                adapter?.updateDataset(CityRepository.citiesNew)
            }
        }
    }
}