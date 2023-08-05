package com.alidiab.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.alidiab.myapplication.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
     private lateinit var biding : ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        biding = ActivitySecondBinding .inflate(layoutInflater)
        setContentView(biding.root)

        val toastMessage = intent.extras?.getString("Welcome")?:"Wlecome"
        Toast.makeText(this
                               ,toastMessage
                                      ,Toast.LENGTH_SHORT)
                                                        .show()
        biding.loginButton.setOnClickListener{
            val res = if(biding.radioButtonFacebook.isChecked)
                1
            else
                2

            val intent = Intent()
            setResult(res ,intent)
            finish()
        }
    }
}