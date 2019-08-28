package com.example.nepomotivacao.ui.main

import android.app.NotificationManager
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.core.app.NotificationCompat
import com.example.nepomotivacao.R
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener, MainContract.View {

    private lateinit var preferences : MainContract.Presenter
    // private lateinit var myNotification : NotificationManager
    private lateinit var user : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        user = edt_nome
        // myNotification = NotificationManager(this,)
        preferences = MainPresenter(this,this)
        verification()
        btn_salvar.setOnClickListener(this)

    }

    override fun onClick(clicked: View) {
        val id = clicked.id

        if(id == R.id.btn_salvar){
            preferences.handleSave(username = user.text.toString())
        }
    }

    fun verification(){
        preferences.onNextActivity()
        finish()
    }

    override fun showAlertMensage(mensage: String)
            = Snackbar.make(myConstraintLayout, mensage, Snackbar.LENGTH_LONG).show()

    override fun nextActivity(activity: Intent)
            = startActivity(activity)

    override fun finishActivity() = finish()
}
