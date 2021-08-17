package com.example.homedeepottest.injection

import com.example.homedeepottest.networking.Api
import com.example.homedeepottest.viewmodel.MyViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


val apiModule = module {

    fun apiProvider(retrofit: Retrofit): Api = retrofit.create(Api::class.java)
    fun retrofitProvider(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://micandadito-default-rtdb.firebaseio.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    single { apiProvider(get()) }
    single { retrofitProvider() }
}

val viewModelModule = module {

    viewModel { MyViewModel(get()) }
}