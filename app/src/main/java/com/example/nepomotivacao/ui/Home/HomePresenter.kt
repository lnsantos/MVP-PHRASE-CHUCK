package com.example.nepomotivacao.ui.Home

import android.content.Context
import com.example.nepomotivacao.R
import com.example.nepomotivacao.Repository.HomeRepository
import com.example.nepomotivacao.Repository.domain.Phrase
import com.example.nepomotivacao.Repository.util.Constants
import com.example.nepomotivacao.api.RetrofitInstance
import com.example.nepomotivacao.ui.main.MainContract
import kotlinx.android.synthetic.main.activity_home.*

class HomePresenter(
    private val  view : HomeContract.View,
    private val context: Context
) : HomeContract.Presenter {

    private val myRepository : HomeContract.Repository = HomeRepository(context,this)

    override fun handlerNameView() {
        view.showUsernameTop(
            myRepository.getPersonaUsername())
    }

    override fun handlerFilterImage(index: Int): Int {
        if(index == R.id.imageAll)
            return Constants.FILTER.ALL

        else if(index == R.id.imageSun)
            return Constants.FILTER.SUN

        else
            return Constants.FILTER.HAPPY
    }

    override fun handlerPhraseView() {
        myRepository.getRandomPhrase()
    }

    override fun onPhrase(phrase: Phrase?) {
        println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA")
        view.showPhrase(phrase!!.value.toString())
    }
}