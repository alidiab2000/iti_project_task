package com.alidiab.myapplication


import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.alidiab.myapplication.databinding.ActivitySecondBinding


class SecondActivity : AppCompatActivity() {

      private lateinit var sharedpref :SharedPreferences
      private lateinit var biding : ActivitySecondBinding
     override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        biding = ActivitySecondBinding .inflate(layoutInflater)
        setContentView(biding.root)
         sharedpref = applicationContext.getSharedPreferences("UserPref", Context.MODE_PRIVATE)
        biding.TextUsername.text = "Welcome ${sharedpref.getString("UserName","User")}"
    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main_activity, menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.logout -> {

                val editor = sharedpref.edit()
                editor.remove("UserName" )
                editor.remove("PassWord"  )
                editor.putBoolean("login" , false)
                editor.commit()
                startActivity(Intent(this , MainActivity::class.java))
                finish()
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }
}