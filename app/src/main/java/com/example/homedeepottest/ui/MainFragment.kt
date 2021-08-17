package com.example.homedeepottest.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.example.homedeepottest.R
import com.example.homedeepottest.databinding.MainFragmentBinding

class MainFragment : Fragment() {

    lateinit var rootView: MainFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        rootView = MainFragmentBinding.inflate(inflater, container, false)
        return rootView.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rootView.run {
            infoBtn.text = "Info Here"
            infoTxt.text = "For More info click here"
            infoBtn.setOnClickListener {
                activity?.supportFragmentManager?.commit {
                    replace(R.id.fragmentContainer, AddressFragment())
                    addToBackStack(null)
                }
            }
        }
    }
}