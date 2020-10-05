package com.example.footballapp.presentation.winners

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.footballapp.BuildConfig
import com.example.footballapp.R
import com.example.footballapp.data.model.WinnersItem
import com.example.footballapp.databinding.WinnersFragmentBinding
import com.example.footballapp.presentation.winners.adapter.OnItemClickListener
import com.example.footballapp.presentation.winners.adapter.WinnersAdapter

class WinnersFragment : Fragment(R.layout.winners_fragment), OnItemClickListener {

    private val teamWinnerViewModel by activityViewModels<WinnersViewModel>()
    private var _binding: WinnersFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = WinnersFragmentBinding.inflate(inflater, container, false)
        val view = binding.root
        val itemAdapter = WinnersAdapter(viewLifecycleOwner, teamWinnerViewModel.items, this)
        binding.recyclerView.adapter = itemAdapter
        if (!BuildConfig.DEBUG) {
            binding.idDebugVersion.visibility = View.GONE
        }
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onItemClicked(winner: WinnersItem) {
        if (winner.startYear!! > 2017) {
            findNavController().navigate(
                WinnersFragmentDirections.actionWinnersFragmentToSeasonFragment(
                    winner.startYear!!
                )
            )
        } else {
            Toast.makeText(context, "No information about this season", Toast.LENGTH_SHORT).show()
        }
    }
}
