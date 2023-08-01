package com.alidiab.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText


class MainActivity : AppCompatActivity()  {
    lateinit var edit :EditText
    lateinit var btn :Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        edit = findViewById(R.id.edit_Text_iti)
        btn = findViewById(R.id.showInput_iti)
        btn.setOnClickListener{
            println(edit.text.toString())
         }
      }




}