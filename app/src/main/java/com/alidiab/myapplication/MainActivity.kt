package com.alidiab.myapplication

import android.annotation.SuppressLint
import android.content.Context

import android.content.Intent
 import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import com.alidiab.myapplication.databinding.ActivityMainBinding
import com.alidiab.myapplication.model.LoginRequest
import com.alidiab.myapplication.utils.ApiInterface
import com.alidiab.myapplication.utils.RetrofitClient
import org.json.JSONObject
import retrofit2.Retrofit


class MainActivity : AppCompatActivity() {

      private lateinit var biding: ActivityMainBinding
      private lateinit var retrofit: ApiInterface
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        biding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(biding.root)
        retrofit = RetrofitClient.getInstance("https://dummyjson.com/")
            .create(ApiInterface::class.java)
        /*-----------------------------------*/
        biding.loginButton.setOnClickListener {

            val body = LoginRequest(biding.editTextUsername.text.toString(),biding.editPass.text.toString() )
            lifecycleScope.launchWhenCreated{
                val response = retrofit.login(body)
                if(response.isSuccessful)
                {
                     moveToNextScreen()
                }else{
                    val json = JSONObject(response.errorBody().toString())
                    Toast.makeText(this@MainActivity,json.getString("message") , Toast.LENGTH_LONG).show()
                }
            }
        }
    }
   private fun moveToNextScreen(){
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