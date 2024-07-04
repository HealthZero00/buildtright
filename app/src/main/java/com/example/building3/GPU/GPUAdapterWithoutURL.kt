// GPUAdapterWithoutURL.kt
package com.example.building3.GPU

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.building3.R

class GPUAdapterWithoutURL(private var gpuList: List<GPUWITHOUTURL>) : RecyclerView.Adapter<GPUAdapterWithoutURL.ViewHolder>() {
    private var selectedGPUIndex: Int = RecyclerView.NO_POSITION
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
                    selectedGPUIndex = position
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
        val gpu = gpuList[position]
        holder.tvName.text = gpu.name
        holder.itemView.isSelected = position == selectedGPUIndex
    }

    override fun getItemCount() = gpuList.size

    fun getItem(position: Int): GPUWITHOUTURL {
        return gpuList[position]
    }

    fun getGPUNames(): List<String> {
        return gpuList.map { it.name }
    }

    fun getSelectedGPUIndex(): Int {
        return selectedGPUIndex
    }

    fun updateList(newList: List<GPUWITHOUTURL>) {
        gpuList = newList
        notifyDataSetChanged()
    }
}
