package me.naingaungluu.uitest.recyclerviews.searchResults

import android.view.LayoutInflater
import android.view.ViewGroup
import com.beyondedgesmm.kotinethin.ui.recyclerview.BaseAdapter
import me.naingaungluu.uitest.databinding.ItemCarSearchResultBinding

class SearchResultListAdapter(private val delegate : SearchResultItemDelegate) : BaseAdapter<SearchResultViewHolder , Int>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchResultViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemCarSearchResultBinding.inflate(inflater , parent , false)
        return SearchResultViewHolder(binding, delegate)
    }

    override fun getItemCount(): Int {
        return 12
    }

    override fun onBindViewHolder(
        holder: SearchResultViewHolder,
        position: Int,
        payloads: MutableList<Any>
    ) {
//        super.onBindViewHolder(holder, position, payloads)
    }
}