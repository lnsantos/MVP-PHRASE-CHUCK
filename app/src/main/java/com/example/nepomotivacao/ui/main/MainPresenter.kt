package com.example.nepomotivacao.ui.main

import android.content.Context
import android.content.Intent
import com.example.nepomotivacao.Repository.MainRepository
import com.example.nepomotivacao.Repository.util.SecurityPreferences
import com.example.nepomotivacao.ui.Home.HomeActivity

class MainPresenter(private val view: MainContract.View,
                    private val context:Context
) : MainContract.Presenter {


    private val myRepository : MainContract.Repository = MainRepository(context,this)
    private lateinit var mySecurity : SecurityPreferences

    override fun onCreated() {
        view.nextActivity(Intent(context,HomeActivity::class.java))
    }

    override fun handleSave(username: String) {

        if(username !is String){
            view.showAlertMensage("Please, insert an text")
        }else if(username.isEmpty()){
            view.showAlertMensage("Please, need fill the user name field")
        }else{
            mySecurity = SecurityPreferences(context)
            myRepository.saveUsername(username = username, security = mySecurity)

            view.showAlertMensage("${username} Saved successfully")
            view.nextActivity(Intent(context,HomeActivity::class.java))
            view.finishActivity()
        }
    }

    override fun onNextActivity() {
        mySecurity = SecurityPreferences(context)
        myRepository.verifyExistPersonal(mySecurity)
    }
}