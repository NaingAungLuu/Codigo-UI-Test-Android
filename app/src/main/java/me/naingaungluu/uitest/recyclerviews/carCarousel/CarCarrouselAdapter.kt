package me.naingaungluu.uitest.recyclerviews.carCarousel

import android.view.LayoutInflater
import android.view.ViewGroup
import com.beyondedgesmm.kotinethin.ui.recyclerview.BaseAdapter
import me.naingaungluu.uitest.databinding.ItemCarCarouselBinding


class CarCarrouselAdapter : BaseAdapter<CarCarouselViewHolder , Int>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarCarouselViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemCarCarouselBinding.inflate(inflater , parent , false)
        return CarCarouselViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return 4
    }

    override fun onBindViewHolder(holder: CarCarouselViewHolder, position: Int) {
//        super.onBindViewHolder(holder, position)
    }
}