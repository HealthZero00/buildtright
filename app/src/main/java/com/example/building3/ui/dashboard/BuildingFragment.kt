package com.example.building3.ui.dashboard

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.building3.Databases.BuildAdapter
import com.example.building3.Databases.BuildDatabase
import com.example.building3.Databases.BuildEntity
import com.example.building3.R
import com.example.building3.databinding.FragmentBuildingBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class BuildingFragment : Fragment() {

    private var _binding: FragmentBuildingBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBuildingBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.addConf.setOnClickListener {
            findNavController().navigate(R.id.action_navigation_building_to_addConfFragment)
        }

        binding.viewBuildsButton.setOnClickListener {
            findNavController().navigate(R.id.action_navigation_building_to_saveConfFragment)
        }

        binding.bugdetButton.setOnClickListener {
            findNavController().navigate(R.id.action_navigation_building_to_budgetConfFragment)
        }

        binding.optimalButton.setOnClickListener {
            findNavController().navigate(R.id.action_navigation_building_to_optimalConfFragment)
        }
        binding.expensiveButton.setOnClickListener {
            findNavController().navigate(R.id.action_navigation_building_to_expensiveConfFragment)
        }






    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    // ...



}