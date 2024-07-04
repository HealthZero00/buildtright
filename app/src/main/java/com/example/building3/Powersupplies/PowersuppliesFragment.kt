package com.example.building3.Powersupplies

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.building3.Motherboards.MotherboardAdapter
import com.example.building3.R

class PowersuppliesFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_powerpupplies, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val powerSuppliesList = listOf(
            POWERSUPPLIES("be quiet! System Power 9 500W", "Bronze", "500W", "2 350", "https://www.regard.ru/product/340334/blok-pitaniia-500w-be-quiet-system-power-9-cm"),
            POWERSUPPLIES("Corsair CV550", "Bronze", "550W", "2 699", ""),
            POWERSUPPLIES("DeepCool DA500", "Bronze", "500W", "2 999", "https://www.regard.ru/product/173270/blok-pitaniia-500w-deepcool-da500"),
            POWERSUPPLIES("be quiet! System Power 9 600W", "Bronze", "600W", "3 099", "https://www.regard.ru/product/278845/blok-pitaniia-600w-be-quiet-system-power-9"),
            POWERSUPPLIES("ExeGate 550PPH", "Bronze", "500W", "3 499", "https://www.regard.ru/product/428326/blok-pitaniia-550w-exegate-550pph-lt-s-oem"),
            POWERSUPPLIES("Montech Beta 550", "Bronze", "550W", "3 599", ""),
            POWERSUPPLIES("1StPlayer DR Premium 5.0", "Bronze", "500W", "3 799", "https://sarov.nix.ru/autocatalog/power_supply_1stplayer/Blok-pitaniya-1STPLAYER-DK-PREMIUM-PS-500AX-500W-ATX-24-plus-2x4-plus-2x6-8pin_518621.html"),
            POWERSUPPLIES("be quiet! System Power 9 700W", "Bronze", "700W", "3 799", "https://www.regard.ru/product/344863/blok-pitaniia-700w-be-quiet-system-power-9-cm"),
            POWERSUPPLIES("Xilence Performance A+ III Series XN082", "Bronze", "550W", "3 899", "https://www.onlinetrade.ru/catalogue/bloki_pitaniya-c339/xilence/blok_pitaniya_xilence_performance_a_iii_xp550r11_550w_bronze_xn082-2388306.html?utm_referrer=https%3a%2f%2fwww.google.com%2f#tabs_description"),
            POWERSUPPLIES("Chieftec Volta VPS-700S", "Bronze", "700W", "3 999", ""),
            POWERSUPPLIES("Cougar VTE500", "Bronze", "500W", "4 099", ""),
            POWERSUPPLIES("Aerocool KCAS Plus 600W", "Bronze", "600W", "4 499", ""),
            POWERSUPPLIES("Corsair CX550F RGB White", "Bronze", "550W", "5 999", ""),
            POWERSUPPLIES("Corsair CX650F RGB", "Bronze", "650W", "6 099", ""),
            POWERSUPPLIES("Aerocool Aero Bronze 750W", "Bronze", "750W", "6 199", ""),
            POWERSUPPLIES("Cooler Master MWE Bronze 600W V2", "Bronze", "600W", "6 199", ""),
            POWERSUPPLIES("Deepcool PK750D", "Bronze", "750W", "6 199", ""),
            POWERSUPPLIES("Gigabyte P650B", "Bronze", "650W", "6 299", ""),
            POWERSUPPLIES("Corsair CX750F RGB", "Bronze", "750W", "6 399", ""),
            POWERSUPPLIES("Thermaltake Smart BX1 RGB 750W", "Bronze", "750W", "6 599", ""),
            POWERSUPPLIES("A-Data XPG Pylon Bronze 750W", "Bronze", "750W", "6 699", ""),
            POWERSUPPLIES("Asus TUF-Gaming-650B", "Bronze", "650W", "10 199", ""),
            POWERSUPPLIES("Chieftec Proton 1000W", "Bronze", "1000W", "10 999", ""),
            POWERSUPPLIES("Thermaltake Smart PRO RGB 850W", "Bronze", "850W", "11 299", ""),
            POWERSUPPLIES("Xilence Performance A+ III Series XN089", "Bronze", "850W", "13 999", ""),
            POWERSUPPLIES("Asus TUF-Gaming-750W", "Bronze", "750W", "15 299", ""),
            POWERSUPPLIES("Chieftec Silicon 850W", "Bronze", "850W", "15 699", ""),
            POWERSUPPLIES("Chieftec Silicon 1000W", "Bronze", "1000W", "18 899", ""),
            POWERSUPPLIES("Corsair CV650", "Bronze", "650W", "4 199", ""),
            POWERSUPPLIES("Zalman GigaMax (GVII) 750W", "Bronze", "750W", "5 699", ""),
            POWERSUPPLIES("ExeGate ServerPRO 600PPH-SE", "Bronze", "600W", "5 899", ""),
            POWERSUPPLIES("Crown Cm-PS500W Pro", "Silver", "500W", "5 499", ""),
            POWERSUPPLIES("ExeGate M650", "Silver", "650W", "6 699", ""),
            POWERSUPPLIES("ExeGate M700", "Silver", "700W", "6 899", ""),
            POWERSUPPLIES("ExeGate M800", "Silver", "800W", "7 099", ""),
            POWERSUPPLIES("ExeGate M750", "Silver", "750W", "7 299", ""),
            POWERSUPPLIES("ExeGate M850", "Silver", "850W", "8 099", ""),
            POWERSUPPLIES("Chieftec Smart 500W", "Standard", "500W", "2 450", ""),
            POWERSUPPLIES("Chieftec Value 500W", "Standard", "500W", "2 899", ""),
            POWERSUPPLIES("Deepcool DN500", "Standard", "500W", "2 899", ""),
            POWERSUPPLIES("Powerman 500W", "Standard", "500W", "3 199", ""),
            POWERSUPPLIES("Pangu Multi-Core King S550 550W", "Standard", "550W", "3 299", ""),
            POWERSUPPLIES("Aerocool Cylon 500W", "Standard", "500W", "3 499", ""),
            POWERSUPPLIES("Aerocool Cylon 600W", "Standard", "600W", "3 999", ""),
            POWERSUPPLIES("Thermaltake TR2 S 600W", "Standard", "600W", "4 799", "")
        )
        val recyclerView: RecyclerView = view.findViewById(R.id.Powersuppliesrv)
        recyclerView.layoutManager = LinearLayoutManager(context)

        // Используйте cpuList из предыдущего шага
        val adapter = PowersuppliesAdapter(powerSuppliesList)
        recyclerView.adapter = adapter
    }
}