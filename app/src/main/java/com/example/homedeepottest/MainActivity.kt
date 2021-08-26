package com.example.homedeepottest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.homedeepottest.databinding.ActivityMainBinding
import kotlin.collections.ArrayList
import kotlin.random.Random


class MainActivity : AppCompatActivity(), Communication {
    private val adapter = Adapter(this)
    private var listInf: ArrayList<Int> =
        arrayListOf(100, 200, 300, 400, 400, 500, 600, 700, 800, 900, 1100)

    private lateinit var mainBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        val view = mainBinding.root
        setContentView(view)
        mainBinding.run {
            recyclerList.adapter = adapter
            adapter.getInfo(listInf)
        }
    }

    override fun changeValue() {
        val random = Random.nextInt(0, 1000)
        listInf.add(random)
        listInf.sort()
        mainBinding.recyclerList.adapter = adapter
        adapter.getInfo(listInf)
    }
}