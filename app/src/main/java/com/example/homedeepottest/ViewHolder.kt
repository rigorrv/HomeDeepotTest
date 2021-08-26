package com.example.homedeepottest

import androidx.recyclerview.widget.RecyclerView
import com.example.homedeepottest.databinding.ItemCounterBinding

class ViewHolder(private val view: ItemCounterBinding, communication: Communication) :
    RecyclerView.ViewHolder(view.root) {

    private val listener = communication
    fun bind(int: Int) {
        view.run {
            numberTxt.text = int.toString()
            if (int == 1100) {
                "add".also { numberTxt.text = it }
                itemView.setOnClickListener {
                    listener.changeValue()
                }
            }
        }
    }

}
