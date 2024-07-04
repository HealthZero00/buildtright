package com.example.building3.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatButton
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.building3.MAIN
import com.example.building3.R
import com.example.building3.databinding.FragmentListBinding

class ListFragment : Fragment() {

    private var _binding: FragmentListBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {


        _binding = FragmentListBinding.inflate(inflater, container, false)
        val root: View = binding.root
        return root
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Предполагая, что у вас есть кнопка в вашем макете
        binding.cpulist.setOnClickListener {
          findNavController().navigate(R.id.action_navigation_list_to_cpuFragment)
        }

        binding.motherboardsList.setOnClickListener {
            findNavController().navigate(R.id.action_navigation_list_to_motherboardsFragment)
        }
        binding.gpuList.setOnClickListener {
            findNavController().navigate(R.id.action_navigation_list_to_GPUFragment)
        }
        binding.powersuppliesList.setOnClickListener {
            findNavController().navigate(R.id.action_navigation_list_to_powerpuppliesFragment)
        }
        binding.ramsList.setOnClickListener {
            findNavController().navigate(R.id.action_navigation_list_to_RAMFragment)
        }

        binding.ssdList.setOnClickListener {
            findNavController().navigate(R.id.action_navigation_list_to_SSDFragment)
        }

        binding.cpucoolerList.setOnClickListener {
            findNavController().navigate(R.id.action_navigation_list_to_cpucoolerFragment)
        }

        binding.corpusList.setOnClickListener {
            findNavController().navigate(R.id.action_navigation_list_to_corpusFragment)
        }
    }

}