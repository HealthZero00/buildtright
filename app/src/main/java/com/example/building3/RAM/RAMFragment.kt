package com.example.building3.RAM

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.building3.Powersupplies.PowersuppliesAdapter
import com.example.building3.R

class RAMFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_r_a_m, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val RAMlist = listOf(

            RAM("ADATA 4G", "399.0", "DDR4", "4G", ""),
            RAM("Kingston ValueRAM 4G", "499.0", "DDR4", "4G", ""),
            RAM("Samsung 8G", "599.0", "DDR4", "8G", ""),
            RAM("AMD Radeon R7 Perfomance Series 4G", "799.0", "DDR4", "4G", ""),
            RAM("Crucial 4G", "899.0", "DDR4", "4G", ""),
            RAM("QUMO 8G", "1 099", "DDR4", "8G", ""),
            RAM("Apacer 16G", "1 199", "DDR4", "16G", ""),
            RAM("Crucial 8G", "1 199", "DDR4", "8G", ""),
            RAM("GeIL Orion 8G", "1 199", "DDR4", "8G", ""),
            RAM("Hynix 8G", "1 199", "DDR4", "8G", ""),
            RAM("Patriot Signature 4G", "1 199", "DDR4", "4G", ""),
            RAM("ADATA XPG Spectrix 8G", "1 999", "DDR4", "8G", ""),
            RAM("Kingston FURY Beast RGB 8G", "1 999", "DDR4", "8G", ""),
            RAM("Silicon Power Xpower Zenith 8G", "1 999", "DDR4", "8G", ""),
            RAM("AMD Radeon R9 Gameer Series 8G", "2 199", "DDR4", "8G", ""),
            RAM("Patriot Viper Elite II 4G", "2 199", "DDR4", "4G", ""),
            RAM("Patriot Viper Steel 8G", "2 199", "DDR4", "8G", ""),
            RAM("QUMO 8G", "2 199", "DDR4", "8G", ""),
            RAM("Kingston FURY Beast Black 8G", "2 250", "DDR4", "8G", ""),
            RAM("ADATA XPG Gammix D10 8G", "2 350", "DDR4", "8G", ""),
            RAM("Apacer 16G", "2 999", "DDR4", "16G", ""),
            RAM("Foxline 16G", "2 999", "DDR4", "16G", ""),
            RAM("GeIL Orion 16G", "2 999", "DDR4", "16G", ""),
            RAM("Hynix 16G", "2 999", "DDR4", "16G", ""),
            RAM("ADATAA XPG Gammix D20 32G", "3 099", "DDR4", "32G", ""),
            RAM("Hynix 8G", "1 499", "DDR5", "8G", ""),
            RAM("AMD Radeon R5 8G", "1 999", "DDR5", "8G", ""),
            RAM("ADATA 8G", "2 099", "DDR5", "8G", ""),
            RAM("Netac Basic 8G", "2 599", "DDR5", "8G", ""),
            RAM("Apacer NOX 8G", "2 699", "DDR5", "8G", ""),
            RAM("Patriot Signature Line 8G", "2 699", "DDR5", "8G", ""),
            RAM("ADATA XPG Lancer 8G", "2 799", "DDR5", "8G", ""),
            RAM("Samsung 8G", "2 999", "DDR5", "8G", ""),
            RAM("Kingston ValueRAM 8G", "3 399", "DDR5", "8G", ""),
            RAM("ADATA XPG Caster RGB 16G", "6 999", "DDR5", "16G", ""),
            RAM("ADATA XPG Lancer Blade 16G", "6 999", "DDR5", "16G", ""),
            RAM("Kingston Fury Beast AMD RGB White 16G", "6 999", "DDR5", "16G", ""),
            RAM("ADATA XPG Lancer 16G", "7 099", "DDR5", "16G", ""),
            RAM("ADATA XPG Lancer RGB 16G", "7 299", "DDR5", "16G", ""),
            RAM("Patriot Viper Venom 8G", "7 299", "DDR5", "8G", ""),
            RAM("Apacer Panther 32G", "9 899", "DDR5", "32G", ""),
            RAM("Kinston FURY Beast White 32G", "9 999", "DDR5", "32G", ""),
            RAM("Silicon Power Xpower Zenith 16G", "9 999", "DDR5", "16G", ""),
            RAM("ADATA XPG Lancer Blade 16G", "10 199", "DDR5", "16G", ""),
            RAM("ADATA 32G", "10 199", "DDR5", "32G", "")
        )

        val recyclerView: RecyclerView = view.findViewById(R.id.RAMrv)
        recyclerView.layoutManager = LinearLayoutManager(context)

        // Используйте cpuList из предыдущего шага
        val adapter = RAMAdapter(RAMlist)
        recyclerView.adapter = adapter

    }


}