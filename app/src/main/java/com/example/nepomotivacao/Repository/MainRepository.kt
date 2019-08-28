package com.example.nepomotivacao.Repository

import android.content.Context
import com.example.nepomotivacao.Repository.util.SecurityPreferences
import com.example.nepomotivacao.Repository.util.Constants
import com.example.nepomotivacao.ui.main.MainContract

class MainRepository(c:Context, private val presenter:MainContract.Presenter) : MainContract.Repository {


    override fun saveUsername(username: String, security: SecurityPreferences) {
        security.storeString(Constants.KEY.USERNAME, username)
    }

    override fun verifyExistPersonal(security: SecurityPreferences) {
        val person = security.getStoreString(Constants.KEY.USERNAME).toString()

        if(!person.isEmpty()){
            presenter.onCreated()
        }
    }

}