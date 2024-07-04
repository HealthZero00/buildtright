package com.example.building3.GPU

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.building3.CPU.CPUAdapter
import com.example.building3.CPU.CPUWITHOUTURL
import com.example.building3.R

class GPUFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_g_p_u, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    val gpuList = listOf(
        GPU("MSI GeForce RTX 4090 Ventus 3X OC", "MSI", "GDDR6X", "183 999", "384 bit", "24G", "https://www.regard.ru/product/464754/videokarta-nvidia-geforce-rtx-4090-msi-24gb-rtx-4090-ventus-3x-24g-oc"),
        GPU("Palit Geforce RTX 4090 GameRock", "Palit", "GDDR6X", "188 999", "384 bit", "24G", "https://www.regard.ru/product/454452/videokarta-nvidia-geforce-rtx-4090-palit-gamerock-24gb-ned4090019sb-1020g"),
        GPU("Palit Geforce RTX 4090 GameRock OC", "Palit", "GDDR6X", "189 999", "384 bit", "24G", "https://www.regard.ru/product/456207/videokarta-nvidia-geforce-rtx-4090-palit-gamerock-oc-24gb-ned4090s19sb-1020g"),
        GPU("Gigabyte GeForce RTX 4090 Gaming OC", "Gigabyte", "GDDR6X", "205 799", "384 bit", "24G", "https://www.regard.ru/product/418854/videokarta-nvidia-geforce-rtx-4090-gigabyte-24gb-gv-n4090gaming-oc-24gd"),
        GPU("Palit Geforce RTX 4090 GameRock OmniBlack", "Palit", "GDDR6X", "197 499", "384 bit", "24G", "https://www.regard.ru/product/457290/videokarta-nvidia-geforce-rtx-4090-palit-gamerock-omniblack-24gb-ned4090019sb-1020q"),
        GPU("MSI GeForce RTX  4090 Suprim X", "MSI", "GDDR6X", "214 999", "384 bit", "24G", "https://www.regard.ru/product/456596/videokarta-nvidia-geforce-rtx-4090-msi-24gb-rtx-4090-suprim-x-24g"),
        GPU("Gigabyte GeForce RTX 4090 Aero OC", "Gigabyte", "GDDR6X", "199 999", "384 bit", "24G", "https://www.regard.ru/product/477904/videokarta-nvidia-geforce-rtx-4090-gigabyte-24gb-gv-n4090aero-oc-24gd"),
        GPU("MSI GeForce RTX 4090 Suprim Liquid X", "MSI", "GDDR6X", "216 999", "384 bit", "24G", "https://www.regard.ru/product/456596/videokarta-nvidia-geforce-rtx-4090-msi-24gb-rtx-4090-suprim-x-24g"),
        GPU("Inno3D GeForce RTX 4090 iCHILL Black", "Inno3D", "GDDR6X", "207 999", "384 bit", "24G", "https://www.regard.ru/product/49314/videokarta-nvidia-geforce-rtx-4090-inno3d-ichill-black-24gb-c4090b-246xx-18330005"),
        GPU("MSI GeForce RTX 4090 X Trio", "MSI", "GDDR6X", "187 999", "384 bit", "24G", "https://www.regard.ru/product/454731/videokarta-nvidia-geforce-rtx-4090-msi-24gb-rtx-4090-gaming-x-trio-24g"),
        GPU("Asus GeForce RTX 4090 TUF Gaming OC Edition", "Asus", "GDDR6X", "215 999", "384 bit", "24G", ""),
        GPU("MSI GeForce RTX 4090 Suprim X Classic", "MSI", "GDDR6X", "198 999", "384 bit", "24G", ""),
        GPU("Inno3D GeForce RTX 4090 iCHILL X3", "Inno3D", "GDDR6X", "175 999", "384 bit", "24G", ""),
        GPU("KFA2 GeForce RTX 4090 HOF", "KFA2", "GDDR6X", "180 999", "384 bit", "24G", ""),
        GPU("MSI GeForce RTX 4090 Suprim Classic", "MSI", "GDDR6X", "177 999", "384 bit", "24G", ""),
        GPU("Inno3D GeForce RTX 4090 iCHILL Frostbite", "Inno3D", "GDDR6X", "179 999", "384 bit", "24G", ""),
        GPU("Colorful iGame GeForce RTX 4090 Advanced OC-V", "Colorful", "GDDR6X", "173 999", "384 bit", "24G", ""),
        GPU("MSI Geforce RTX 4090 Suprim", "MSI", "GDDR6X", "146 499", "384 bit", "24G", ""),
        GPU("Gigabyte GeForce RTX 4090 Aorus Master", "Gigabyte", "GDDR6X", "181 999", "384 bit", "24G", ""),
        GPU("Gigabyte GeForce RTX 4090 Aorus Xtreme", "Gigabyte", "GDDR6X", "155 999", "384 bit", "24G", ""),
        GPU("KFA2 GeForce RTX 4090 SG-1-Click OC", "KFA2", "GDDR6X", "139 999", "384 bit", "24G", ""),
        GPU("Gigabyte GeForce RTX 4090 Aorus Xtreme Waterforce", "Gigabyte", "GDDR6X", "155 999", "384 bit", "24G", ""),
        GPU("Asus GeForce RTX 4090 ROG Strix OC Edition", "Asus", "GDDR6X", "254 400", "384 bit", "24G", ""),
        GPU("Asus GeForce RTX 4090 ROG Strix White OC Edition", "Asus", "GDDR6X", "176 166", "384 bit", "24G", ""),
        GPU("Gigabyte GeForce RTX 4090 Windforce", "Gigabyte", "GDDR6X", "190 195", "384 bit", "24G", ""),
        GPU("MSI GeForce RTX 4080 Suprim X", "MSI", "GDDR6X", "160 999", "256 bit", "16G", ""),
        GPU("Palit GeForce RTX 4080 GameRock OmniBlack", "Palit", "GDDR6X", "139 999", "256 bit", "16G", ""),
        GPU("Gigabyte GeForce RTX 4080 Eagle OC", "Gigabyte", "GDDR6X", "142 499", "256 bit", "16G", ""),
        GPU("Gigabyte GeForce RTX 4080 Gaming OC", "Gigabyte", "GDDR6X", "146 999", "256 bit", "16G", ""),
        GPU("MSI GeForce RTX 4080 Gaming X Trio White", "MSI", "GDDR6X", "145 999", "256 bit", "16G", ""),
        GPU("Palit GeForce RTX 4080 GameRock", "Palit", "GDDR6X", "134 499", "256 bit", "16G", ""),
        GPU("Palit GeForce RTX 4080 GamingPro", "Palit", "GDDR6X", "137 499", "256 bit", "16G", ""),
        GPU("Gigabyte GeForce RTX 4080 Aero OC", "Gigabyte", "GDDR6X", "144 499", "256 bit", "16G", ""),
        GPU("Gigabyte GeForce RTX 4080 Aorus Master", "Gigabyte", "GDDR6X", "165 999", "256 bit", "16G", ""),
        GPU("Gigabyte GeForce RTX 4080 Eagle", "Gigabyte", "GDDR6X", "141 999", "256 bit", "16G", ""),
        GPU("Gigabyte GeForce RTX 4080 Aero", "Gigabyte", "GDDR6X", "141 499", "256 bit", "16G", ""),
        GPU("MSI GeForce RTX 4080 Gaming X Trio", "MSI", "GDDR6X", "147 999", "256 bit", "16G", ""),
        GPU("Palit GeForce RTX 4080 JetStream", "Palit", "GDDR6X", "129 999", "256 bit", "16G", ""),
        GPU("KFA2 GeForce RTX 4080 SG-1-Click OC", "KFA2", "GDDR6X", "133 999", "256 bit", "16G", ""),
        GPU("MSI GeForce RTX 4080 Ventus 3X OC", "MSI", "GDDR6X", "132 499", "256 bit", "16G", ""),
        GPU("Inno3D GeForce RTX 4080 iCHILL Frostbite", "Inno3D", "GDDR6X", "165 999", "256 bit", "16G", ""),
        GPU("MSI GeForce RTX 4080 Gaming X Slim White", "MSI", "GDDR6X", "145 999", "256 bit", "16G", ""),
        GPU("Palit GeForce RTX 4080 GameRock OC", "Palit", "GDDR6X", "139 499", "256 bit", "16G", ""),
        GPU("Palit GeForce RTX 4080 GamingPro OC", "Palit", "GDDR6X", "135 999", "256 bit", "16G", ""),
        GPU("MSI GeForce RTX 4080 Suprim", "MSI", "GDDR6X", "147 499", "256 bit", "16G", "")
    )

        val recyclerView: RecyclerView = view.findViewById(R.id.GPUrv)
        recyclerView.layoutManager = LinearLayoutManager(context)

        // Используйте cpuList из предыдущего шага
        val adapter = GPUAdapter(gpuList)
        recyclerView.adapter = adapter
        }
}