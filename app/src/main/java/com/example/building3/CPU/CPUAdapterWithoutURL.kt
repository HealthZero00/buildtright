package com.example.building3.CPU

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.building3.R

class CPUAdapterWithoutURL(private var cpuList: List<CPUWITHOUTURL>) : RecyclerView.Adapter<CPUAdapterWithoutURL.ViewHolder>() {
    private var selectedCpuIndex: Int = RecyclerView.NO_POSITION
    private lateinit var onItemClickListener: OnItemClickListener

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener: OnItemClickListener) {
        onItemClickListener = listener
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvName: TextView = view.findViewById(R.id.CPUName)

        init {
            itemView.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    selectedCpuIndex = position
                    notifyDataSetChanged() // Обновить весь список для обновления UI
                    onItemClickListener.onItemClick(position)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_cpu, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val cpu = cpuList[position]
        holder.tvName.text = cpu.name
        holder.itemView.isSelected = position == selectedCpuIndex
    }

    override fun getItemCount() = cpuList.size

    fun getCpuNames(): List<String> {
        return cpuList.map { it.name }
    }

    fun getSelectedCpuIndex(): Int {
        return selectedCpuIndex
    }

    fun getItem(position: Int): CPUWITHOUTURL {
        return cpuList[position]
    }

    fun updateList(newList: List<CPUWITHOUTURL>) {
        cpuList = newList
        notifyDataSetChanged()
    }
}
