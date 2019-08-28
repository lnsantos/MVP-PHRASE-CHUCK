package com.example.nepomotivacao.Repository.domain

data class Phrase(val categories: Array<String>? = null,
                  val created_at: String = "",
                  val icon_url:String = "",
                  val id: String = "",
                  val updated_at: String = "",
                  val url: String = "",
                  val value: String = "")