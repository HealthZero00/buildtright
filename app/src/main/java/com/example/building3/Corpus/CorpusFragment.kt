package com.example.building3.Corpus

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.building3.CPU.CPUAdapter
import com.example.building3.R


class CorpusFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_corpus, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val corpusList = listOf(
            CORPUS("Сougar Duoface Pro RGB", "8 199", ""),
            CORPUS("ARDOR Gaming Rare M2 ARGB", "5 999", ""),
            CORPUS("Cougar Duoface Pro RGB White", "8 599", ""),
            CORPUS("ARDOR Gaming Rare Minicase MS1", "5 499", ""),
            CORPUS("Cougar Duoface RGB White", "5 999", ""),
            CORPUS("ARDOR Gaming Rare Minicase", "3 499", ""),
            CORPUS("Lian Li Lancool III", "13 699", ""),
            CORPUS("Cougar MX330-F", "5 499", ""),
            CORPUS("ARDOR Gaming Rare Minicase MS2 WG", "3 399", ""),
            CORPUS("Zalman i3 Edge", "5 199", ""),
            CORPUS("Deepcool Matrexx 30", "3 299", ""),
            CORPUS("Deepcool CC560 WH", "5 399", ""),
            CORPUS("Deepcool CK560", "7 499", ""),
            CORPUS("Zalman N4 Rev.1", "5 399", ""),
            CORPUS("AeroCool Cylon Mini", "3 099", ""),
            CORPUS("ARDOR Gaming C305 V2", "6 399", ""),
            CORPUS("Montech X3 Glass", "5 499", ""),
            CORPUS("AeroCool Cylon", "3 399", ""),
            CORPUS("DeepCool CC360 WH ARGB", "4 199", ""),
            CORPUS("Montech SKY TWO", "8 699", ""),
            CORPUS("DeepCool CC360 ARGB", "4 899", ""),
            CORPUS("ARDOR Gaming Rare Minicase MS3 Mesh WG ARGB", "3 999", ""),
            CORPUS("AeroCool Cylon", "3 499", ""),
            CORPUS("AeroCool CS-1103", "2 899", ""),
            CORPUS("Lian Li PC-011 Dynamic XL ROG Certify", "20 999", ""),
            CORPUS("DeepCool Matrexx 50 Mesh 4FS", "6 299", ""),
            CORPUS("Montech Air 903 Max", "7 999", ""),
            CORPUS("Zalman i3", "5 599", ""),
            CORPUS("Deepcool Matrexx 55 Mesh ADD-RGB 4F", "6 599", ""),
            CORPUS("AeroCool Aero One Mini Frost", "5 999", ""),
            CORPUS("Lian Li Lancool II Mesh Snow edition", "9 999", ""),
            CORPUS("ADATA XPG Valor Mesh C", "7 299", ""),
            CORPUS("MSI Mag Force 111R", "4 399", ""),
            CORPUS("Cougar Archon 2 Mesh RGB", "4 599", ""),
            CORPUS("MSI Mag Force 112R", "6 899", ""),
            CORPUS("Deepcool CK500", "5 299", ""),
            CORPUS("Thermaltake Core X71 TG", "18 999", ""),
            CORPUS("AeroCool Aero One Mini", "4 499", ""),
            CORPUS("Thermaltake View 51 Tempered Glass ARGB Edition", "18 499", ""),
            CORPUS("Cougar MX330-G Air", "5 199", ""),
            CORPUS("Zalman S4", "4 199", ""),
            CORPUS("Cougar DarkBlader-S", "11 499", ""),
            CORPUS("Cougar Panzer EVO RGB", "19 999", ""),
            CORPUS("DeepCool CH560 Digital WH", "8 999", ""),
            CORPUS("AeroCool Tor Pro", "11 399", "")
        )

        val recyclerView: RecyclerView = view.findViewById(R.id.Corpusrv)
        recyclerView.layoutManager = LinearLayoutManager(context)

        // Используйте cpuList из предыдущего шага
        val adapter = CorpusAdapter(corpusList)
        recyclerView.adapter = adapter
    }

}
