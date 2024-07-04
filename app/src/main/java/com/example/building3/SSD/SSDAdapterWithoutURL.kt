package com.example.building3.SSD

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.building3.R

class SSDAdapterWithoutURL(private var ssdList: List<SSDWITHOUTURL>) : RecyclerView.Adapter<SSDAdapterWithoutURL.ViewHolder>() {
    private var selectedSSDIndex: Int = RecyclerView.NO_POSITION
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
                    selectedSSDIndex = position
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
        val ssd = ssdList[position]
        holder.tvName.text = ssd.name
        holder.itemView.isSelected = position == selectedSSDIndex
    }

    override fun getItemCount() = ssdList.size

    fun getItem(position: Int): SSDWITHOUTURL {
        return ssdList[position]
    }

    fun getSSDNames(): List<String> {
        return ssdList.map { it.name }
    }

    fun getSelectedSSDIndex(): Int {
        return selectedSSDIndex
    }

    fun updateList(newList: List<SSDWITHOUTURL>) {
        ssdList = newList
        notifyDataSetChanged()
    }
}
