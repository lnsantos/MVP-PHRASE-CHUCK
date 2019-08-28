package com.example.nepomotivacao.Repository

import android.content.Context
import android.util.Log
import com.example.nepomotivacao.Repository.domain.Phrase
import com.example.nepomotivacao.Repository.util.Constants
import com.example.nepomotivacao.Repository.util.SecurityPreferences
import com.example.nepomotivacao.api.RetrofitInstance
import com.example.nepomotivacao.api.RetrofitService
import com.example.nepomotivacao.ui.Home.HomeContract
import com.example.nepomotivacao.ui.Home.HomePresenter
import com.example.nepomotivacao.ui.main.MainContract
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.time.Clock


class HomeRepository(c:Context,private val presenter: HomeContract.Presenter) : HomeContract.Repository {

    private var mySecurity: SecurityPreferences = SecurityPreferences(c)
    private var myRetrofit = RetrofitInstance

    override fun getPersonaUsername(): String {
        return mySecurity.getStoreString(Constants.KEY.USERNAME).toString()
    }

    override fun getRandomPhrase() {
        var phraseOBJ: Phrase? = null
        var phrase = myRetrofit.getService().getPhrase().enqueue(object : Callback<Phrase> {
            override fun onFailure(call: Call<Phrase>, t: Throwable) {
                Log.d("ERROR", "Error")
            }

            override fun onResponse(call: Call<Phrase>, response: Response<Phrase>) {
                if (response.isSuccessful) {
                    phraseOBJ = response.body()

                    presenter.onPhrase(phraseOBJ)
                }else{
                    println("FALSOSOOOSOOSOSOSOS")
                }
            }
        })
    }
}

