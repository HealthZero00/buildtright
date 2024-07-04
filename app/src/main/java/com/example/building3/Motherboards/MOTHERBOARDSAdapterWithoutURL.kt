package com.example.building3.Motherboards

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.building3.R

class MOTHERBOARDSAdapterWithoutURL(private var motherboardList: List<MOTHERBOARDSWITHOUTURL>) : RecyclerView.Adapter<MOTHERBOARDSAdapterWithoutURL.ViewHolder>() {
    private var selectedMotherboardIndex: Int = RecyclerView.NO_POSITION
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
                    selectedMotherboardIndex = position
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
        val motherboard = motherboardList[position]
        holder.tvName.text = motherboard.name
        holder.itemView.isSelected = position == selectedMotherboardIndex
    }

    override fun getItemCount() = motherboardList.size

    fun getItem(position: Int): MOTHERBOARDSWITHOUTURL {
        return motherboardList[position]
    }

    fun getMotherboardNames(): List<String> {
        return motherboardList.map { it.name }
    }

    fun getSelectedMotherboardIndex(): Int {
        return selectedMotherboardIndex
    }

    fun updateList(newList: List<MOTHERBOARDSWITHOUTURL>) {
        motherboardList = newList
        notifyDataSetChanged()
    }
}
