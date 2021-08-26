package com.example.homedeepottest

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.homedeepottest.databinding.ItemCounterBinding

class Adapter(private val communication: Communication) : RecyclerView.Adapter<ViewHolder>() {

    private var infoList = arrayListOf<Int>()

    fun getInfo(info: ArrayList<Int>) {
        infoList = info
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = ItemCounterBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view,communication)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(infoList[position])
    }

    override fun getItemCount(): Int {
        return infoList.size
    }
}