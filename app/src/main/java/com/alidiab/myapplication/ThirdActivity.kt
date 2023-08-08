package com.alidiab.myapplication

import android.app.Activity
import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.alidiab.myapplication.databinding.ActivityThirdBinding

class ThirdActivity :AppCompatActivity(){
   private lateinit var binding :ActivityThirdBinding
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
         setContentView(binding.root)


    }
}