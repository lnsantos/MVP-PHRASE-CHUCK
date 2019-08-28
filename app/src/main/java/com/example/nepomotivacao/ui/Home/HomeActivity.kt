package com.example.nepomotivacao.ui.Home

import android.content.Context
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.nepomotivacao.R
import com.example.nepomotivacao.Repository.util.Constants
import com.example.nepomotivacao.ui.main.MainContract
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity(), HomeContract.View, View.OnClickListener {
    
    private var myFilterPhrase : Int = Constants.FILTER.ALL
    private lateinit var presenter : HomeContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        presenter = HomePresenter(this, this)
        presenter.handlerNameView()
        setListener()

    }

    override fun onClick(p0: View) {
       val index = p0.id

       val indexs = listOf<Int>(R.id.imageAll, R.id.imageHappy, R.id.imageSun)
       if(index in indexs) {
           myFilterPhrase = presenter.handlerFilterImage(index)
           changeIcon(myFilterPhrase)
       }else{
           presenter.handlerPhraseView()
       }
    }

    override fun showUsernameTop(username: String) {
        txt_user.text = username
    }

    override fun changeIcon(id: Int) {
        if(id == Constants.FILTER.ALL){
            imageAll.setImageResource(R.drawable.ic_selected)
            imageSun.setImageResource(R.drawable.ic_sun)
            imageHappy.setImageResource(R.drawable.ic_happy)

            myConstraintLayoutHome.setBackgroundColor(Color.BLUE)

        }else if(id == Constants.FILTER.SUN){
            imageSun.setImageResource(R.drawable.ic_selected)
            imageAll.setImageResource(R.drawable.ic_all)
            imageHappy.setImageResource(R.drawable.ic_happy)

            myConstraintLayoutHome.setBackgroundColor(Color.GREEN)
        }else{
            imageHappy.setImageResource(R.drawable.ic_selected)
            imageSun.setImageResource(R.drawable.ic_sun)
            imageAll.setImageResource(R.drawable.ic_all)

            myConstraintLayoutHome.setBackgroundColor(Color.BLACK)
        }
    }

    // o presenter ta chamando esse metodo, sim
    override fun showPhrase(p: String) {
        txt_user.text = p
    }

    override fun setListener() {
       imageAll.setOnClickListener(this)
       imageSun.setOnClickListener(this)
       imageHappy.setOnClickListener(this)
       btn_newPhase.setOnClickListener(this)
    }
}
