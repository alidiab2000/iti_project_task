package com.alidiab.myapplication

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import androidx.core.view.get
import com.alidiab.myapplication.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity()  {
    private lateinit var biding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        biding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(biding.root)

       biding.loginButton.setOnClickListener{
           val userText : String  = biding.editTextUsername.text.toString()
           val userempty = biding.editTextUsername.text.isEmpty()
           val passempty = biding.editTextUsername.text.isEmpty()
           val passText : String  = biding.editPass.text.toString()
           val gender   = if(biding.radiomale.isChecked) biding.radiomale.text.toString()
           else if(biding.radiofemale.isChecked)
               biding.radiofemale.text.toString()
           else {
               "plz chose gender"
           }
           if(passempty && userempty || gender =="plz chose gender" ){
               Toast.makeText(this , "Not vald email or pass or gender" , Toast.LENGTH_LONG).show()
           }

           else {
               Toast.makeText(
                   this,
                   "your Email is $userText and your pass is $passText  and your gender is $gender",
                   Toast.LENGTH_LONG
               ).show()
           }
       }


    }




}