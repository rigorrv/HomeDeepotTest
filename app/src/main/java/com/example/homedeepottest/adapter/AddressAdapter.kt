package com.example.homedeepottest.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.homedeepottest.communicator.Communicator
import com.example.homedeepottest.databinding.ItemsViewBinding
import com.example.homedeepottest.model.Addres

class AddressAdapter(private val communicator: Communicator) : RecyclerView.Adapter<ViewHolder>() {

    var listInfo: List<Addres> = mutableListOf()

    fun getInfo(info: List<Addres>) {
        listInfo = info
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = ItemsViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view, communicator)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listInfo[position])
    }

    override fun getItemCount(): Int = listInfo.size
}