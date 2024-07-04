package com.example.building3.CpuCooler

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.building3.Motherboards.MotherboardAdapter
import com.example.building3.R

class CpucoolerFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cpucooler, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val cpucoolerList = listOf(
            CPUCOOLER("Deepcool Gammaxx 300", "1 299", ""),
            CPUCOOLER("Deepcool AK629", "6 999", ""),
            CPUCOOLER("ID-Cooling SE-224-XTS ARGB", "2 899", ""),
            CPUCOOLER("Deepcool Gammax 420 V2 Blue", "2 450", ""),
            CPUCOOLER("ID-Cooling SE-224-XTS", "2 599", ""),
            CPUCOOLER("Deepcool AG620 BK ARGB", "6 299", ""),
            CPUCOOLER("Deepcool Gammaxx 300B", "1 699", ""),
            CPUCOOLER("Deepcool AK400", "2 450", ""),
            CPUCOOLER("ID-Cooling SE-206-XT", "3 199", ""),
            CPUCOOLER("Deepcool Gamma Archer", "899.0", ""),
            CPUCOOLER("ID-Cooling SE-224-XTS", "2 699", ""),
            CPUCOOLER("Deepcool AG300 MARRS", "1 399", ""),
            CPUCOOLER("Deepcool Gammaxx GTE V2", "2 099", ""),
            CPUCOOLER("be quiet! Dark Rock Pro 4", "14 499", ""),
            CPUCOOLER("Deepcool AK400 WH", "5 999", ""),
            CPUCOOLER("AeroCool Rime 4 ARGB", "3 299", ""),
            CPUCOOLER("Cooler Master Hyper 212 Spectrum", "3 299", ""),
            CPUCOOLER("be quiet! Shadow Rock 3", "6 699", ""),
            CPUCOOLER("be quiet! Pure Rock 2", "5 399", ""),
            CPUCOOLER("Zalman CNPS4X", "2 350", ""),
            CPUCOOLER("Thermaltake Toughair 110", "3 699", ""),
            CPUCOOLER("Zalman CNPS9X Performa", "2 999", ""),
            CPUCOOLER("Zalman CNPS10X Optima II_Black", "3 299", ""),
            CPUCOOLER("Zalman CNPS10X Optima II_White", "3 299", ""),
            CPUCOOLER("Thermaltake Toughhair 310", "3 199", ""),
            CPUCOOLER("AeroCool Rave 3 FRGB", "2 099", ""),
            CPUCOOLER("Zalman CNPS9X Performa ARGB", "3 299", ""),
            CPUCOOLER("Cooler Master MasterAir MA610P ARGB", "5 999", ""),
            CPUCOOLER("Deepcool AK500 Digital", "7 499", ""),
            CPUCOOLER("Zalman CNPS20X", "5 399", ""),
            CPUCOOLER("Thermalright Silver Arrow IB-E Extreme Rev. B", "11 999", ""),
            CPUCOOLER("Cooler Master I70C", "1 599", ""),
            CPUCOOLER("Cougar Forza 50", "3 099", ""),
            CPUCOOLER("Artic Cooling Freezer 34 eSports DUO", "5 599", ""),
            CPUCOOLER("Zalman CNPS 9X Optima RGB", "2 250", ""),
            CPUCOOLER("Cooler Master Hyper T200", "1 699", ""),
            CPUCOOLER("PentaWave Z06D", "9 299", ""),
            CPUCOOLER("Cooler Master I30", "799.0", ""),
            CPUCOOLER("AeroColl Raven 4 FRGB PWM 4P", "2 250", ""),
            CPUCOOLER("Thermalright Ultra-120 EX Rev.4", "6 999", ""),
            CPUCOOLER("Iceberg Thermal IceSLEET G4 Midnight", "7 499", ""),
            CPUCOOLER("be quiet! Pure Rock 2 FX", "7 999", ""),
            CPUCOOLER("Cooler Master Hyper 212 Spectrum V2", "2 750", ""),
            CPUCOOLER("Cooler Master Hyper 212X", "3 699", ""),
            CPUCOOLER("Thermalright SI-100", "5 399", "")
        )
        val recyclerView: RecyclerView = view.findViewById(R.id.Cpucoolerrv)
        recyclerView.layoutManager = LinearLayoutManager(context)

        // Используйте cpuList из предыдущего шага
        val adapter = CpucoolerAdapter(cpucoolerList)
        recyclerView.adapter = adapter
    }
}