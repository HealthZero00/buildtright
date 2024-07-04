package com.example.building3.Powersupplies

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.building3.R

class PowersuppliesAdapterWithoutURL(private var powersuppliesList: List<POWERSUPPLIESWITHOUTURL>) : RecyclerView.Adapter<PowersuppliesAdapterWithoutURL.ViewHolder>() {
    private var selectedPowersupplyIndex: Int = RecyclerView.NO_POSITION
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
                    selectedPowersupplyIndex = position
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
        val powersupply = powersuppliesList[position]
        holder.tvName.text = powersupply.name
        holder.itemView.isSelected = position == selectedPowersupplyIndex
    }

    override fun getItemCount() = powersuppliesList.size

    fun getItem(position: Int): POWERSUPPLIESWITHOUTURL {
        return powersuppliesList[position]
    }

    fun getPowersuppliesName(): List<String> {
        return powersuppliesList.map { it.name }
    }

    fun getSelectedPowersuppliesIndex(): Int {
        return selectedPowersupplyIndex
    }

    fun updateList(newList: List<POWERSUPPLIESWITHOUTURL>) {
        powersuppliesList = newList
        notifyDataSetChanged()
    }
}
