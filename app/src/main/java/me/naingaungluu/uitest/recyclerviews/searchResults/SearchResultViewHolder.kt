package me.naingaungluu.uitest.recyclerviews.searchResults

import com.beyondedgesmm.kotinethin.ui.recyclerview.BaseViewHolder
import me.naingaungluu.uitest.databinding.ItemCarSearchResultBinding

class SearchResultViewHolder(private val binding : ItemCarSearchResultBinding,private val delegate : SearchResultItemDelegate) : BaseViewHolder<Int>(binding.root) {

    init {
        binding.root.setOnClickListener {
            delegate.onTapSearchResult()
        }
    }

    override fun setData(data: Int) {

    }
}