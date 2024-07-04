package com.example.building3

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.building3.Databases.BuildAdapter
import com.example.building3.Databases.BuildDatabase
import com.example.building3.Databases.BuildEntity
import com.example.building3.databinding.FragmentSaveConfBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SaveConfFragment : Fragment() {

    private var _binding: FragmentSaveConfBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSaveConfBinding.inflate(inflater, container, false)
        val root: View = binding.root

        GlobalScope.launch {
            val allBuilds = BuildDatabase.getInstance(requireContext()).buildDao().getAllBuilds()

            // Отобразите сохраненные сборки в RecyclerView
            withContext(Dispatchers.Main) {
                showSavedBuildsInRecyclerView(allBuilds)
            }
        }

        return root
    }

    private fun showSavedBuildsInRecyclerView(builds: List<BuildEntity>) {
        val recyclerView: RecyclerView = binding.savedBuildsRecyclerView
        val adapter = BuildAdapter(builds)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = adapter

        // Добавление разделителя между элементами списка
        val dividerItemDecoration = DividerItemDecoration(context, LinearLayoutManager.VERTICAL)
        dividerItemDecoration.setDrawable(resources.getDrawable(R.drawable.divider, null))
        recyclerView.addItemDecoration(dividerItemDecoration)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
