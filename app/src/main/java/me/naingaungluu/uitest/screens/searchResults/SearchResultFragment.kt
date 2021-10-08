package me.naingaungluu.uitest.screens.searchResults

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.layout_search_result.view.*
import me.naingaungluu.uitest.databinding.FragmentSearchResultsBinding
import me.naingaungluu.uitest.recyclerviews.searchResults.SearchResultListAdapter
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView.VERTICAL
import android.graphics.drawable.InsetDrawable
import androidx.navigation.fragment.findNavController
import me.naingaungluu.uitest.recyclerviews.searchResults.SearchResultItemDelegate
import android.R
import kotlinx.android.synthetic.main.layout_car_details_app_bar.view.*

class SearchResultFragment : Fragment() , SearchResultItemDelegate{

    private var _binding : FragmentSearchResultsBinding? = null
    private val binding : FragmentSearchResultsBinding
    get() = _binding!!

    private val searchResultAdapter : SearchResultListAdapter by lazy { SearchResultListAdapter(this) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = FragmentSearchResultsBinding.inflate(inflater , container , false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUi()
        setupListeners()
    }

    private fun setupUi() {
        with(binding.layoutSearchResult){
            rvSearchResult.adapter = searchResultAdapter
            rvSearchResult.addItemDecoration(getDividerDecorator())
            rvSearchResult.layoutManager = LinearLayoutManager(requireContext() , LinearLayoutManager.VERTICAL , false)
        }
    }

    private fun getDividerDecorator() : DividerItemDecoration {
        val attrs = intArrayOf(R.attr.listDivider)
        val a = requireContext().obtainStyledAttributes(attrs)
        val divider = a.getDrawable(0)
        val inset = resources.getDimensionPixelSize(me.naingaungluu.uitest.R.dimen.margin_medium_1x)
        val insetDivider = InsetDrawable(divider, inset, 0, inset, 0)
        a.recycle()
        return DividerItemDecoration(requireContext(), VERTICAL).apply {
            setDrawable(insetDivider)
        }
    }

    private fun setupListeners() {
        binding.layoutAppBar.btnBack.setOnClickListener {
            findNavController().navigateUp()
        }
    }

    override fun onTapSearchResult() {
        findNavController().navigate(SearchResultFragmentDirections.actionSearchResultFragmentToCarDetailsFragment())
    }

}