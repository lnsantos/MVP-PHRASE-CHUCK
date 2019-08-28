package com.example.nepomotivacao.ui.Home

import android.content.Context
import com.example.nepomotivacao.Repository.domain.Phrase

interface HomeContract {

    interface View{
        fun setListener()
        fun changeIcon(id:Int)
        fun showUsernameTop(username:String)
        fun showPhrase(p:String)
    }

    interface Repository{
        fun getPersonaUsername() : String
        fun getRandomPhrase()
    }
// vou criar um de qualquer jeito só pra voce ver como éé
    interface Presenter{
        fun handlerFilterImage(index: Int) : Int
        fun handlerNameView()
        fun handlerPhraseView()
        fun onPhrase(phrase: Phrase?)
    }

}