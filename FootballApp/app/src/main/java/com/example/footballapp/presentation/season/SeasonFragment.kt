package com.example.footballapp.presentation.season

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.footballapp.R
import com.example.footballapp.databinding.SeasonFragmentBinding
import com.example.footballapp.presentation.season.adapter.SeasonAdapter

class SeasonFragment : Fragment(R.layout.season_fragment) {
    private val seasonViewModel by viewModels<SeasonViewModel>()
    private var _binding: SeasonFragmentBinding? = null
    private val binding get() = _binding!!
    private val seasonStartYear by lazy { navArgs<SeasonFragmentArgs>().value.seasonStartYear }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = SeasonFragmentBinding.inflate(inflater, container, false)
        val view = binding.root
        val itemAdapter = SeasonAdapter(viewLifecycleOwner, seasonViewModel.items)
        binding.tableRecyclerView.adapter = itemAdapter
        seasonViewModel.seasonStartYear = seasonStartYear
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
