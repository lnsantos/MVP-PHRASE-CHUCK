package com.example.nepomotivacao.Repository.util

import android.content.Context
import android.content.SharedPreferences

class SecurityPreferences (c: Context){

    private val sharedIntance : SharedPreferences
            = c.getSharedPreferences("motiva", Context.MODE_PRIVATE)

    fun storeString (key:String, value:String)
            = sharedIntance.edit().putString(key,value).apply()

    fun getStoreString(key:String): String?
            = sharedIntance.getString(key, "Valor não encontrado!")

}