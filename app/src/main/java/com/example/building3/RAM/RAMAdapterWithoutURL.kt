package com.example.building3.RAM

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.building3.R

class RAMAdapterWithoutURL(private var ramList: List<RAMWITHOUTURL>) : RecyclerView.Adapter<RAMAdapterWithoutURL.ViewHolder>() {
    private var selectedRAMIndex: Int = RecyclerView.NO_POSITION
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
                    selectedRAMIndex = position
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
        val ram = ramList[position]
        holder.tvName.text = ram.name
        holder.itemView.isSelected = position == selectedRAMIndex
    }

    override fun getItemCount() = ramList.size

    fun getItem(position: Int): RAMWITHOUTURL {
        return ramList[position]
    }

    fun getRAMNames(): List<String> {
        return ramList.map { it.name }
    }

    fun getSelectedRAMIndex(): Int {
        return selectedRAMIndex
    }

    fun updateList(newList: List<RAMWITHOUTURL>) {
        ramList = newList
        notifyDataSetChanged()
    }
}
