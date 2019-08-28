package com.example.nepomotivacao.ui.main

import android.content.Intent
import com.example.nepomotivacao.Repository.util.SecurityPreferences

interface MainContract {


    interface View{
        fun showAlertMensage(mensage:String)
        fun nextActivity(activity: Intent)
        fun finishActivity()
        // fun showNotification(title:String,mensagem:String)
    }

    interface Repository{
        fun saveUsername(username:String, security: SecurityPreferences)
        fun verifyExistPersonal(security: SecurityPreferences)
    }

    interface Presenter{
        fun handleSave(username:String)
        fun onNextActivity()
        fun onCreated()
    }

}