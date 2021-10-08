package me.naingaungluu.uitest.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import kotlinx.android.synthetic.main.layout_car_details_app_bar.view.*
import kotlinx.android.synthetic.main.layout_car_details_carousel.*
import kotlinx.android.synthetic.main.layout_car_details_carousel.view.*
import me.naingaungluu.uitest.databinding.FragmentCarDetailsBinding
import me.naingaungluu.uitest.recyclerviews.carCarousel.CarCarrouselAdapter

class CarDetailsFragment : Fragment()  {

    private var _binding : FragmentCarDetailsBinding? = null
    private val binding : FragmentCarDetailsBinding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCarDetailsBinding.inflate(inflater , container , false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUi()
        setupListeners()
    }

    private fun setupUi() {
        with(binding.layoutCarCarrousel.vpCarousel) {
            adapter = CarCarrouselAdapter()
        }
        binding.layoutCarCarrousel.viewIndicator.count = 4
    }

    private fun setupListeners() {
        binding.layoutCarCarrousel.vpCarousel.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels)
                binding.layoutCarCarrousel.viewIndicator.selection = position
            }
        })
        binding.layoutAppBar.btnBack.setOnClickListener { findNavController().navigateUp() }
    }
}