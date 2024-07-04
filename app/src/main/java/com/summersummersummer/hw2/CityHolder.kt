package com.summersummersummer.hw2

import android.content.Context
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.RequestManager
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.summersummersummer.R
import com.summersummersummer.databinding.ItemCityBinding

class CityHolder(
    private val binding: ItemCityBinding,
    private val glide: RequestManager,
    private val onClick: (City) -> Unit,
) : ViewHolder(binding.root) {

    private val requestOptions = RequestOptions
        .diskCacheStrategyOf(
            DiskCacheStrategy.ALL
        )

    private val context: Context
        get() = itemView.context

    fun onBind(city: City) {
        binding.run {
            tvCity.text = city.name
            tvCountry.text = city.country

            glide
                .load(city.url)
                .error(R.drawable.baseline_error_outline_24)
                .placeholder(R.drawable.baseline_grade_24)
                .apply(requestOptions)
                .into(ivImage)

            root.setOnClickListener {
                onClick.invoke(city)
            }

            tvCity.setTextColor(context.getColor(city.getTitleColor()))
        }
    }

    private fun City.getTitleColor(): Int = if (url.length > 120) {
        R.color.pink_700
    } else {
        R.color.green_200
    }
}