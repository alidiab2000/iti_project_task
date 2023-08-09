package com.alidiab.myapplication

import android.annotation.SuppressLint
import android.content.Context

import android.content.Intent
 import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.alidiab.myapplication.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

      private lateinit var biding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        biding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(biding.root)

        /*-----------------------------------*/
        biding.loginButton.setOnClickListener {
            val  sharedpref = applicationContext.getSharedPreferences("UserPref",Context.MODE_PRIVATE)
            val editor = sharedpref.edit()
            editor.putString("UserName" , biding.editTextUsername.text.toString())
            editor.putString("PassWord" , biding.editPass.text.toString())
            editor.putBoolean("login" , true)
            editor.commit()

            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
            finish()

        }
    }


}