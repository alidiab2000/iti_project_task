package com.alidiab.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.alidiab.myapplication.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity()  {
    lateinit var biding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        biding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(biding.root)
       biding.showInputIti.setOnClickListener{
           print(biding.showInputIti.text.toString())
       }

      }




}