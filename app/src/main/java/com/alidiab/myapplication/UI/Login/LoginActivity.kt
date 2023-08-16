package com.alidiab.myapplication.UI.Login


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.alidiab.myapplication.databinding.ActivityMainBinding
import com.alidiab.myapplication.UI.Second.MainActivity


class LoginActivity : AppCompatActivity() {

      private lateinit var biding: ActivityMainBinding
      private lateinit var viewModel : LoginViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        biding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(biding.root)
        viewModel = LoginViewModel(this , biding)
        viewModel.loginData.observe(this){
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        biding.loginButton.setOnClickListener {
             viewModel.startLogin(biding.editTextUsername.text.toString() , biding.editPass.text.toString())
        }
    }


}