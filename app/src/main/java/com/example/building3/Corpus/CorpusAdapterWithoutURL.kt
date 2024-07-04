// CorpusAdapterWithoutURL.kt
package com.example.building3.Corpus

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.building3.R

class CorpusAdapterWithoutURL(private var corpusList: List<CORPUSWITHOUTURL>) : RecyclerView.Adapter<CorpusAdapterWithoutURL.ViewHolder>() {
    private var selectedCorpusIndex: Int = RecyclerView.NO_POSITION
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
                    selectedCorpusIndex = position
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
        val corpus = corpusList[position]
        holder.tvName.text = corpus.name
        holder.itemView.isSelected = position == selectedCorpusIndex
    }

    override fun getItemCount() = corpusList.size

    fun getItem(position: Int): CORPUSWITHOUTURL {
        return corpusList[position]
    }

    fun getCorpusNames(): List<String> {
        return corpusList.map { it.name }
    }

    fun getSelectedCorpusIndex(): Int {
        return selectedCorpusIndex
    }

    fun updateList(newList: List<CORPUSWITHOUTURL>) {
        corpusList = newList
        notifyDataSetChanged()
    }
}
