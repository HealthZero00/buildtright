package com.example.building3.Motherboards

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.building3.R


class MotherboardsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_motherboards, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val motherboardList = listOf(
            MOTHERBOARDS("Asus ROG Maximus XI Exteme", "Asus", "E-ATX", "29 999", "LGA1151-2", "Z390", "DDR4", "https://rog.asus.com/ru/motherboards/rog-maximus/rog-maximus-xi-extreme-model/spec/"),
            MOTHERBOARDS("EVGA Z390 Dark", "EVGA", "E-ATX", "45 399", "LGA1151-2", "Z390", "DDR4", "https://www.onlinetrade.ru/catalogue/materinskie_platy-c340/evga/materinskaya_plata_evga_z390_dark_lga1151_eatx_131_cs_e399_kr-2013747.html?utm_referrer=https%3a%2f%2fwww.google.com%2f#tabs_description"),
            MOTHERBOARDS("Gigabyte Z390 Aorus Xtreme Waterforce", "Gigabyte", "E-ATX", "53 499", "LGA1151-2", "Z390", "DDR4", "https://www.gigabyte.ru/products/page/mb/z390_aorus_xtreme_waterforce/sp"),
            MOTHERBOARDS("MSI MEG Z390 Golike", "MSI", "E-ATX", "50 699", "LGA1151-2", "Z390", "DDR4", "https://www.msi.com/Motherboard/MEG-Z390-GODLIKE/Specification"),
            MOTHERBOARDS("Gigabyte Z390 Aorus Xtreme", "Gigabyte", "E-ATX", "82 099", "LGA1151-2", "Z390", "DDR4", "https://www.gigabyte.ru/products/page/mb/z390_aorus_xtreme/sp"),
            MOTHERBOARDS("Asrock Z390 Extreme4", "Asrock", "ATX", "14 799", "LGA1151-2", "Z390", "DDR4", "https://www.asrock.com/mb/Intel/Z390%20Extreme4/index.ru.asp"),
            MOTHERBOARDS("Asrock Z390 Phantom Gaming 4", "Asrock", "ATX", "6 399", "LGA1151-2", "Z390", "DDR4", "https://pg.asrock.com/mb/Intel/Z390%20Phantom%20Gaming%204/index.ru.asp"),
            MOTHERBOARDS("Asrock Z390 Phantom Gaming 4S", "Asrock", "ATX", "7 399", "LGA1151-2", "Z390", "DDR4", "https://pg.asrock.com/mb/Intel/Z390%20Phantom%20Gaming%204S/index.ru.asp"),
            MOTHERBOARDS("Asrock Z390 Phantom Gaming X", "Asrock", "ATX", "7 399", "LGA1151-2", "Z390", "DDR4", "https://pg.asrock.com/mb/Intel/Z390%20Phantom%20Gaming%20X/index.ru.asp"),
            MOTHERBOARDS("Asrock Z390 Phantom Gaming 6", "Asrock", "ATX", "10 499", "LGA1151-2", "Z390", "DDR4", "https://pg.asrock.com/mb/Intel/Z390%20Phantom%20Gaming%206/index.ru.asp"),
            MOTHERBOARDS("Asrock Z390 Phantom Gaming 7", "Asrock", "ATX", "21 099", "LGA1151-2", "Z390", "DDR4", "https://pg.asrock.com/mb/Intel/Z390%20Phantom%20Gaming%207/index.ru.asp"),
            MOTHERBOARDS("Asrock Z390 Phantom Gaming 9", "Asrock", "ATX", "18 980", "LGA1151-2", "Z390", "DDR4", "https://pg.asrock.com/mb/Intel/Z390%20Phantom%20Gaming%209/index.ru.asp"),
            MOTHERBOARDS("Asrock Z390 Phantom Gaming SLI", "Asrock", "ATX", "15 499", "LGA1151-2", "Z390", "DDR4", "https://pg.asrock.com/mb/Intel/Z390%20Phantom%20Gaming%20SLI/index.ru.asp"),
            MOTHERBOARDS("Asrock Z390 Pro4", "Asrock", "ATX", "13 350", "LGA1151-2", "Z390", "DDR4", ""),
            MOTHERBOARDS("Asrock Z390 Steel Legend", "Asrock", "ATX", "9 381", "LGA1151-2", "Z390", "DDR4", ""),
            MOTHERBOARDS("Asrock Z390 Taichi", "Asrock", "ATX", "23 284", "LGA1151-2", "Z390", "DDR4", ""),
            MOTHERBOARDS("Asrock Z390 Taichi Ultimate", "Asrock", "ATX", "16 990", "LGA1151-2", "Z390", "DDR4", ""),
            MOTHERBOARDS("Gigabyte B360N GSM", "Gigabyte", "Mini-ITX", "10 168", "LGA1151-2", "B360", "DDR4", ""),
            MOTHERBOARDS("MSI B360I Gaming Pro AC", "MSI", "Mini-ITX", "7 505", "LGA1151-2", "B360", "DDR4", ""),
            MOTHERBOARDS("Asus Prime H310-Plus", "Asus", "ATX", "7 110", "LGA1151-2", "H310", "DDR4", ""),
            MOTHERBOARDS("Asus Prime H310-Plus Gaming", "Asus", "ATX", "7 379", "LGA1151-2", "H310", "DDR4", ""),
            MOTHERBOARDS("Gigabyte H310 D3", "Gigabyte", "ATX", "5 880", "LGA1151-2", "H310", "DDR4", ""),
            MOTHERBOARDS("MSI H310-A Pro", "MSI", "ATX", "4 000", "LGA1151-2", "H310", "DDR4", ""),
            MOTHERBOARDS("MSI H310-F Pro", "MSI", "ATX", "7 800", "LGA1151-2", "H310", "DDR4", ""),
            MOTHERBOARDS("Asrock H310CM-DVS", "Asrock", "Micro-ATX", "5 649", "LGA1151-2", "H310", "DDR4", ""),
            MOTHERBOARDS("Asrock H310CM-HDV", "Asrock", "Micro-ATX", "5 359", "LGA1151-2", "H310", "DDR4", ""),
            MOTHERBOARDS("Asrock H310CM-DGS", "Asrock", "Micro-ATX", "4 760", "LGA1151-2", "H310", "DDR4", ""),
            MOTHERBOARDS("Asrock H310CM-HDVP", "Asrock", "Micro-ATX", "4 799", "LGA1151-2", "H310", "DDR4", ""),
            MOTHERBOARDS("Asus EX-H310M-V3", "Asus", "Micro-ATX", "7 414", "LGA1151-2", "H310", "DDR4", ""),
            MOTHERBOARDS("Asus Prime H310M-A", "Asus", "Micro-ATX", "4 800", "LGA1151-2", "H310", "DDR4", ""),
            MOTHERBOARDS("Asus Prime H310M-C", "Asus", "Micro-ATX", "7 035", "LGA1151-2", "H310", "DDR4", ""),
            MOTHERBOARDS("Asus Prime H310M-D", "Asus", "Micro-ATX", "8 602", "LGA1151-2", "H310", "DDR4", ""),
            MOTHERBOARDS("Asus Prime H310M-E", "Asus", "Micro-ATX", "7 960", "LGA1151-2", "H310", "DDR4", ""),
            MOTHERBOARDS("Asus Prime H310M-K", "Asus", "Micro-ATX", "3 600", "LGA1151-2", "H310", "DDR4", ""),
            MOTHERBOARDS("Asus Prime H310M-Plus Gaming", "Asus", "Micro-ATX", "7 695", "LGA1151-2", "H310", "DDR4", ""),
            MOTHERBOARDS("Asrock H610M-HVS", "Asrock", "Micro-ATX", "7 099", "LGA1700", "H610", "DDR4", ""),
            MOTHERBOARDS("Colorful H610M-K M.2 V20", "Coloful", "Micro-ATX", "7 299", "LGA1700", "H610", "DDR4", ""),
            MOTHERBOARDS("Gigabyte B660M DS3H", "Gigabyte", "Micro-ATX", "8 999", "LGA1700", "B660", "DDR4", ""),
            MOTHERBOARDS("MSI B660M-A Pro", "MSI", "Micro-ATX", "7 499", "LGA1700", "B660", "DDR4", ""),
            MOTHERBOARDS("Asrock B660M-ITX/ac", "Asrock", "Mini-ITX", "9 190", "LGA1700", "B660", "DDR4", ""),
            MOTHERBOARDS("Asus Pro Q670M-C-CSM", "Asus", "Micro-ATX", "13 799", "LGA1700", "Q670", "DDR4", ""),
            MOTHERBOARDS("Asus Prime Z690M-Plus", "Asus", "Micro-ATX", "13 999", "LGA1700", "Z690", "DDR4", ""),
            MOTHERBOARDS("ASUS Prime H410M-E", "Asus", "Micro-ATX", "5 499", "LGA1200", "H410", "DDR4", ""),
            MOTHERBOARDS("MSI H410M PRO", "MSI", "Micro-ATX", "5 299", "LGA1200", "H410", "DDR4", ""),
            MOTHERBOARDS("Gigabyte H410M H", "Gigabyte", "Micro-ATX", "4 299", "LGA1200", "H410", "DDR4", "")
        )
        val recyclerView: RecyclerView = view.findViewById(R.id.MOTHERBOARDSrv)
        recyclerView.layoutManager = LinearLayoutManager(context)

        // Используйте cpuList из предыдущего шага
        val adapter = MotherboardAdapter(motherboardList)
        recyclerView.adapter = adapter
    }
}