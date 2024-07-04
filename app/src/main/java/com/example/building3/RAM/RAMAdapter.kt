package com.example.building3.RAM

import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.building3.R

class RAMAdapter(private val ramList: List<RAM>) : RecyclerView.Adapter<RAMAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvName: TextView = view.findViewById(R.id.CPUName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_cpu, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val ram = ramList[position]
        holder.tvName.text = ram.name

        holder.itemView.setOnClickListener {
            openUrlInApp(holder.itemView.context, ram.url)
        }
    }

    private fun openUrlInApp(context: Context, url: String) {
        val webView = WebView(context)
        webView.settings.javaScriptEnabled = true
        webView.settings.cacheMode = WebSettings.LOAD_CACHE_ELSE_NETWORK
        webView.webViewClient = WebViewClient()
        webView.loadUrl(url)

        AlertDialog.Builder(context)
            .setView(webView)
            .setPositiveButton("OK") { dialog, _ ->
                dialog.dismiss()
            }
            .show()
    }

    override fun getItemCount() = ramList.size
}
