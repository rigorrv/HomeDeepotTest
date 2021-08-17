package com.example.homedeepottest.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.homedeepottest.model.JsonData
import com.example.homedeepottest.networking.Api
import kotlinx.coroutines.launch

class MyViewModel(private val api: Api) : ViewModel() {

    var jsonLiveData = MutableLiveData<JsonData>()

    fun getInfo() {
        viewModelScope.launch {
            jsonLiveData.postValue(api.getJson().body())
        }
    }
}