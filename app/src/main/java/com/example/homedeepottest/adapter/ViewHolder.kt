package com.example.homedeepottest.adapter

import androidx.recyclerview.widget.RecyclerView
import com.example.homedeepottest.communicator.Communicator
import com.example.homedeepottest.databinding.AddressFragmentBinding
import com.example.homedeepottest.databinding.ItemsViewBinding
import com.example.homedeepottest.model.Addres

class ViewHolder(val view: ItemsViewBinding, communicator: Communicator) :
    RecyclerView.ViewHolder(view.root) {

    val listener = communicator
    fun bind(info: Addres) {
        view.run {
            addressTxt.text = info.address
            priceTxt.text = info.cost
        }
        itemView.setOnClickListener {
            listener.getInfo(info)
        }
    }

}
