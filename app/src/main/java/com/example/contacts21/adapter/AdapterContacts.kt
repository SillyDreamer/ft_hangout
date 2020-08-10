package com.example.contacts21.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.contacts21.R

class AdapterContacts(private val list: ArrayList<Pair<String, String>>) : RecyclerView.Adapter<AdapterContacts.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(position)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val firstname : TextView = itemView.findViewById(R.id.firstname)
        val lastname : TextView = itemView.findViewById(R.id.lastname)

        fun bind(position : Int) {
            firstname.text = list[position].first
            lastname.text = list[position].second
        }
    }

}