package com.nishant4820.youtubelayout.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.nishant4820.youtubelayout.adapters.MainAdapter
import com.nishant4820.youtubelayout.databinding.FragmentHomeBinding
import com.nishant4820.youtubelayout.viewmodels.MainViewModel

class HomeFragment : Fragment() {

    companion object {
        // Function to create a new instance of Fragment
        fun newInstance() = HomeFragment()
    }

    // Variables Defined
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: MainViewModel
    private lateinit var mainAdapter: MainAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Initialising the Variables
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        mainAdapter = MainAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflating the Layout
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Setting up the Main Recycler View in HomeFragment
        binding.mainRecyclerView.setHasFixedSize(true)
        binding.mainRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.mainRecyclerView.adapter = mainAdapter

        // Observing the ViewModel for changes in RecyclerView Data
        viewModel.dataList.observe(
            viewLifecycleOwner
        ) { value -> mainAdapter.setData(value) }
        viewModel.getMockData()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}