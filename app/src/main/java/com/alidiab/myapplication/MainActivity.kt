package com.alidiab.myapplication

import android.content.Intent
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
           val passText : String  = biding.editPass.text.toString()
           val gender   = if(biding.radiomale.isChecked)
               biding.radiomale.text.toString()
           else if(biding.radiofemale.isChecked)
               biding.radiofemale.text.toString()
           else {
               "plz chose gender"
           }

           val toast = "Welcome $userText your pass is  $passText  your gender is $gender "
           val intent =   Intent(this, SecondActivity::class.java)
           intent.putExtra("Welcome", toast )
           startActivityForResult(intent ,  101)
           onActivityResult(101 , 1 , intent)
       }
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode ==  101) {
            if(resultCode == 1){
                Toast.makeText(this,"FaceBook login ",Toast.LENGTH_SHORT).show()
            }else {
                Toast.makeText(this,"Google login ",Toast.LENGTH_SHORT).show()
            }
        }
    }


}




