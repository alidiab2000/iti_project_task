package com.alidiab.myapplication.screen
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.alidiab.myapplication.UI.Login.LoginActivity
import com.alidiab.myapplication.UI.Second.MainActivity

import com.alidiab.myapplication.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity() {
    private lateinit var  binding :ActivitySplashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(binding.root)
        val sharedpref = applicationContext.getSharedPreferences("UserPref", Context.MODE_PRIVATE)
        val isLog = sharedpref.getBoolean("login" , false)

        Handler().postDelayed({
            if(isLog){
                startActivity(Intent(this, MainActivity::class.java))
            }else
            {
                startActivity(Intent(this, LoginActivity::class.java))
            }
            finish()

        },3000)
    }
}
