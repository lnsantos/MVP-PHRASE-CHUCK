package com.example.nepomotivacao.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    //
    //
     val myRetrofit: Retrofit by lazy {
         Retrofit.Builder()
        .baseUrl("https://api.chucknorris.io/jokes/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    }

    fun getService() : RetrofitService = myRetrofit.create(RetrofitService::class.java)

}//calma ae deix