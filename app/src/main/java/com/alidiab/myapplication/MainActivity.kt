package com.alidiab.myapplication

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.alidiab.myapplication.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity()  {
    private lateinit var biding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        biding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(biding.root)

        val loginButton: Button = findViewById(R.id.loginButton)
        loginButton.setBackgroundColor(Color.RED)

      }




}