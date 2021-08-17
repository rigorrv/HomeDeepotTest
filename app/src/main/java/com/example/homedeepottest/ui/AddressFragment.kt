package com.example.homedeepottest.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.homedeepottest.R
import com.example.homedeepottest.adapter.AddressAdapter
import com.example.homedeepottest.communicator.Communicator
import com.example.homedeepottest.databinding.AddressFragmentBinding
import com.example.homedeepottest.model.Addres
import com.example.homedeepottest.viewmodel.MyViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class AddressFragment : Fragment(), Communicator {

    lateinit var rootView: AddressFragmentBinding
    private val myViewModel: MyViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        rootView = AddressFragmentBinding.inflate(inflater, container, false)
        return rootView.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val adapter = AddressAdapter(this@AddressFragment)
        rootView.run {
            myViewModel.getInfo()
            mainToolBar.setOnMenuItemClickListener {
                when (it.itemId) {
                    R.id.backIcon -> {
                        activity?.onBackPressed()
                    }
                }
                true
            }
            mainToolBar.setNavigationOnClickListener {
                activity?.onBackPressed()
            }
            myViewModel.jsonLiveData.observe(viewLifecycleOwner, {
                listRecycler.adapter = adapter
                adapter.getInfo(it.address)
                Glide.with(this@AddressFragment)
                    .load(it.home.headimg)
                    .into(mainImage)
            })
        }
    }

    override fun getInfo(info: Addres) {
        rootView.mainToolBar.title = info.address
        Glide.with(this)
            .load(info.image)
            .into(rootView.mainImage)
    }
}