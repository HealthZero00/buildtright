package com.example.building3.CPU

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.building3.R


class CpuFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cpu, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val cpuList = listOf(
            CPU("Intel Core i5-9600KF", "Intel", "Core i5", "8 199", "LGA1151-2", "https://www.regard.ru/product/299740/processor-intel-core-i5-9600k-oem"),
            CPU("Intel Core i7-13700K", "Intel", "Core i7", "44 999", "LGA1700", "https://www.regard.ru/product/458961/processor-intel-core-i7-13700k-oem"),
            CPU("Intel Core i7-10700K", "Intel", "Core i7", "27 999", "LGA1200", "Intel Core i7-10700K"),
            CPU("Intel Core i3-12300", "Intel", "Core i3", "11 599", "LGA1700", "https://www.dns-shop.ru/product/71de0a634e60ed20/processor-intel-core-i3-12300-oem/characteristics/"),
            CPU("Intel Core i9-9900K", "Intel", "Core i9", "36 999", "LGA1151-2", "https://www.dns-shop.ru/product/e5972335bfd63330/processor-intel-core-i9-9900k-oem/characteristics/"),
            CPU("Intel Core i9-12900K", "Intel", "Core i9", "48 999", "LGA1700", "https://www.regard.ru/product/411816/processor-intel-core-i9-12900k-oem"),
            CPU("Intel Core i5-12600KF", "Intel", "Core i5", "24 499", "LGA1700", "https://www.regard.ru/product/412304/processor-intel-core-i5-12600kf-oem"),
            CPU("Intel Core i5-10600K", "Intel", "Core i5", "18 699", "LGA1200", "https://www.regard.ru/product/354307/processor-intel-core-i5-10600k-oem"),
            CPU("Intel Core i5-10600KF", "Intel", "Core i5", "19 499", "LGA1200", "https://www.regard.ru/product/367205/processor-intel-core-i5-10600kf-oem"),
            CPU("Intel Core i7-8700K", "Intel", "Core i7", "13 999", "LGA1151-2", "https://www.dns-shop.ru/product/38f80b9c8e103330/processor-intel-core-i7-8700k-3747ghz-6c12t-12mb-l3-ddr4-2666-gpu-uhd-630-tdp-95w-lga1151-v2-oem/"),
            CPU("Intel Core i5-8600", "Intel", "Core i5", "8 899", "LGA1151-2", "https://www.dns-shop.ru/product/56887f0803e03330/processor-intel-core-i5-8600-3143ghz-6c6t-9mb-l3-ddr4-2666-gpu-uhd-630-tdp-65w-lga1151-v2-oem/"),
            CPU("Intel Core i5-11400", "Intel", "Core i5", "17 199", "LGA1200", ""),
            CPU("Intel Core i9-12900KF", "Intel", "Core i9", "41 499", "LGA1700", ""),
            CPU("Intel Core i3-9350KF", "Intel", "Core i3", "12 383", "LGA1151-2", ""),
            CPU("Intel Core i5-12600K", "Intel", "Core i5", "25 999", "LGA1700", ""),
            CPU("Intel Core i5-9400F", "Intel", "Core i5", "9 799", "LGA1151-2", ""),
            CPU("Intel Core i5-12400", "Intel", "Core i5", "18 899", "LGA1700", ""),
            CPU("Intel Core i3-10325", "Intel", "Core i3", "10 999", "LGA1200", ""),
            CPU("Intel Core i9-10900K", "Intel", "Core i9", "59 999", "LGA1200", ""),
            CPU("Intel Core i3-9100", "Intel", "Core i3", "10 999", "LGA1151-2", ""),
            CPU("Intel Core i9-10920X", "Intel", "Core i9", "38 999", "LGA2066", ""),
            CPU("Intel Core i7-12700K", "Intel", "Core i7", "35 499", "LGA1700", ""),
            CPU("Intel Core i7-10700KF", "Intel", "Core i7", "25 499", "LGA1200", ""),
            CPU("Intel Core i5-12500", "Intel", "Core i5", "22 199", "LGA1700", "")
        )

        val recyclerView: RecyclerView = view.findViewById(R.id.CPUrv)
        recyclerView.layoutManager = LinearLayoutManager(context)

        // Используйте cpuList из предыдущего шага
        val adapter = CPUAdapter(cpuList)
        recyclerView.adapter = adapter


    }

}