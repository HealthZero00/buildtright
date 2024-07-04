// CpucoolerAdapterWithoutURL.kt
package com.example.building3.CpuCooler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.building3.R

class CpucoolerAdapterWithoutURL(private var cpucoolerList: List<CPUCOOLERWITHOUTURL>) : RecyclerView.Adapter<CpucoolerAdapterWithoutURL.ViewHolder>() {
    private var selectedCpucoolerIndex: Int = RecyclerView.NO_POSITION
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
                    selectedCpucoolerIndex = position
                    notifyDataSetChanged()
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
        val cpucooler = cpucoolerList[position]
        holder.tvName.text = cpucooler.name
        holder.itemView.isSelected = position == selectedCpucoolerIndex
    }

    override fun getItemCount() = cpucoolerList.size

    fun getItem(position: Int): CPUCOOLERWITHOUTURL {
        return cpucoolerList[position]
    }

    fun getCpucoolerNames(): List<String> {
        return cpucoolerList.map { it.name }
    }

    fun getSelectedCpucoolerIndex(): Int {
        return selectedCpucoolerIndex
    }

    fun updateList(newList: List<CPUCOOLERWITHOUTURL>) {
        cpucoolerList = newList
        notifyDataSetChanged()
    }
}
