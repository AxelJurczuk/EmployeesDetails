package com.example.android.employeesdetails.ui.overview

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.android.employeesdetails.databinding.FragmentOverviewBinding
import com.example.android.employeesdetails.data.Result

class OverviewFragment : Fragment() {

    private var _binding: FragmentOverviewBinding? = null
    private val binding get() = _binding!!
    private val viewModel: EmployeeViewModel by viewModels()
    private lateinit var adapter: EmployeeAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentOverviewBinding.inflate(inflater, container, false)

        val employeeObserver = Observer<Result> {
            when (it) {
                is Result.Success -> {
                    adapter.employeeList = it.resultList
                    adapter.notifyDataSetChanged()
                }
                is Result.Failure -> Toast.makeText(
                    requireContext(),
                    "Something went wrong",
                    Toast.LENGTH_SHORT
                )
                    .show()
            }
        }

        viewModel.getListData().observe(viewLifecycleOwner, employeeObserver)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = binding.recyclerView
        adapter = EmployeeAdapter(requireContext(), object : EmployeeAdapter.OnItemClick {
            override fun onItemClickListener(position: Int) {
                val employee = adapter.employeeList[position]
                val action = OverviewFragmentDirections.actionOverviewFragmentToDetailFragment(employee)
                findNavController().navigate(action)
            }

        })
        recyclerView.adapter = adapter
        recyclerView.setHasFixedSize(true)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}