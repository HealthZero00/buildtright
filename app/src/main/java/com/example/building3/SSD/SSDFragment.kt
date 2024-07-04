package com.example.building3.SSD

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.building3.R
import com.example.building3.SSDs.SSDAdapter

class SSDFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_s_s_d, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val ssdList = listOf(
            SSD("SATA Kingston A400 480G", "3 399", "N/A", "480G", ""),
            SSD("SATA Samsung 870 EVO 1000G", "8 999", "N/A", "1000G", ""),
            SSD("SATA Kingston A400 240G", "2 399", "N/A", "240G", ""),
            SSD("SATA Samsung 870 EVO 500G", "6 399", "N/A", "500G", ""),
            SSD("SATA Kingston A400 960G", "5 999", "N/A", "960G", ""),
            SSD("SATA Apacer AS350 Panther 512G", "3 699", "N/A", "512G", ""),
            SSD("SATA Samsung 870 QVO 1000G", "7 899", "N/A", "1000G", ""),
            SSD("SATA Samsung 870 EVO 250G", "5 199", "N/A", "250G", ""),
            SSD("SATA ADATA SU650 240G", "2 199", "N/A", "240G", ""),
            SSD("SATA ADATA SU650 480G", "3 299", "N/A", "480G", ""),
            SSD("SATA Apacer AS350 Panther 1000G", "5 999", "N/A", "1000G", ""),
            SSD("SATA Samsung 870 QVO 2000G", "12 999", "N/A", "2000G", ""),
            SSD("SATA Samsung 870 EVO 500G", "6 499", "N/A", "500G", ""),
            SSD("SATA Apacer AS350 Panther 256G", "2 199", "N/A", "256G", ""),
            SSD("SATA ExeGate NextPro 480G", "3 299", "N/A", "480G", ""),
            SSD("SATA ExeGate NextPro 120G", "1 399", "N/A", "120G", ""),
            SSD("SATA Transcend SSD250N 2000G", "30 799", "N/A", "2000G", ""),
            SSD("SATA AGI AI238 1000G", "4 699", "N/A", "1000G", ""),
            SSD("SATA AGI AI238 500G", "2 399", "N/A", "500G", ""),
            SSD("SATA AGI AI138 256G", "1 599", "N/A", "256G", ""),
            SSD("SATA WD Blue SA510 500G", "5 099", "N/A", "500G", ""),
            SSD("SATA Kingston KC600 2048G", "16 499", "N/A", "2048G", ""),
            SSD("SATA AMD Radeon R5 Series 256G", "1 999", "N/A", "256G", ""),
            SSD("SATA ADATA SU635 240G", "2 699", "N/A", "240G", ""),
            SSD("SATA WD Red SA500 500G", "6 899", "N/A", "500G", ""),
            SSD("M.2 ARDOR Gaming Ally AL1288 1024G", "5 499", "NVMe", "1024G", ""),
            SSD("M.2 ADATA XPG Gammix S11 Pro 1000G", "6 299", "NVMe", "1000G", ""),
            SSD("M.2 Samsung 980 Pro 1000G", "11 999", "NVMe", "1000G", ""),
            SSD("M.2 Samsung 970 EVO Plus 1000G", "9 399", "NVMe", "1000G", ""),
            SSD("M.2 Samsung 980 1000G", "9 499", "NVMe", "1000G", ""),
            SSD("M.2 ARDOR Gaming Ally Al1284 512G", "3 299", "NVMe", "512G", ""),
            SSD("M.2 Samsung 970 EVO Plus 500G", "5 999", "NVMe", "500G", ""),
            SSD("M.2 ADATA Legend 960 Max 2000G", "13 999", "NVMe", "2000G", ""),
            SSD("M.2 Samsung 970 EVO Plus 2000G", "18 299", "NVMe", "2000G", ""),
            SSD("M.2 Samsung 990 Pro 1000G", "13 999", "NVMe", "1000G", ""),
            SSD("M.2 Apacer AS2280P4 480G", "3 599", "NVMe", "480G", ""),
            SSD("M.2 HP EX900 1000G", "5 999", "NVMe", "1000G", ""),
            SSD("M.2 Apacer AS2280Q4 1000G", "6 799", "NVMe", "1000G", ""),
            SSD("M.2 MSI Spatium M460 1000G", "8 899", "NVMe", "1000G", ""),
            SSD("M.2 Silicon Power UD85 2000G", "11 499", "NVMe", "2000G", ""),
            SSD("M.2 Gigabyte Aorus Gen4 5000E 500G", "6 199", "NVMe", "500G", ""),
            SSD("M.2 WD Green SN350 1000G", "5 999", "NVMe", "1000G", ""),
            SSD("M.2 ADATA XPG SX6000 Lite 128G", "1 599", "NVMe", "128G", ""),
            SSD("M.2 Apacer AS2280P4 512G", "3 999", "NVMe", "512G", ""),
            SSD("M.2 WD Black SN750 SE 500G", "6 699", "NVMe", "500G", "")
        )


        val recyclerView: RecyclerView = view.findViewById(R.id.SSDrv)
        recyclerView.layoutManager = LinearLayoutManager(context)

        val adapter = SSDAdapter(ssdList)
        recyclerView.adapter = adapter

    }

}