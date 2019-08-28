package com.example.nepomotivacao.api

import com.example.nepomotivacao.Repository.domain.Phrase
import retrofit2.Call
import retrofit2.http.GET

interface RetrofitService {

    @GET("random")
     fun getPhrase() : Call<Phrase>

}