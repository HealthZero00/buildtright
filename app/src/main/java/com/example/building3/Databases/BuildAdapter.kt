package com.example.building3.Databases

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.building3.R

class BuildAdapter(private val builds: List<BuildEntity>) :
    RecyclerView.Adapter<BuildAdapter.BuildViewHolder>() {

    class BuildViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BuildViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_build, parent, false)
        return BuildViewHolder(view)
    }

    override fun onBindViewHolder(holder: BuildViewHolder, position: Int) {
        val build = builds[position]

        // Устанавливаем имя сборки в TextView

        // Устанавливаем материнскую плату в TextView
        holder.itemView.findViewById<TextView>(R.id.buildMotherboardTextView).text =
            build.motherboard1?.name ?: "Материнская плата не выбрана"

        // Устанавливаем процессор в TextView
        holder.itemView.findViewById<TextView>(R.id.buildCpuTextView).text =
            build.cpu1?.name ?: "Процессор не выбран"

        // Устанавливаем видеокарту в TextView
        holder.itemView.findViewById<TextView>(R.id.buildGpuTextView).text =
            build.gpu1?.name ?: "Видеокарта не выбрана"

        // Устанавливаем блок питания в TextView
        holder.itemView.findViewById<TextView>(R.id.buildPowersupplyTextView).text =
            build.powersupply1?.name ?: "Блок питания не выбран"

        // Устанавливаем оперативную память в TextView
        holder.itemView.findViewById<TextView>(R.id.buildRAMTextView).text =
            build.ram1?.name ?: "Оперативная память не выбрана"

        // Устанавливаем твердотельный накопитель в TextView
        holder.itemView.findViewById<TextView>(R.id.buildSSDTextView).text =
            build.ssd1?.name ?: "Твердотельный накопитель не выбран"

        // Устанавливаем кулер в TextView
        holder.itemView.findViewById<TextView>(R.id.buildCpucoolerTextView).text =
            build.cpucooler1?.name ?: "Кулер не выбран"

        // Устанавливаем корпус в TextView
        holder.itemView.findViewById<TextView>(R.id.buildCorpusTextView).text =
            build.corpus1?.name ?: "Корпус не выбран"
    }

    override fun getItemCount(): Int {
        return builds.size
    }
}
