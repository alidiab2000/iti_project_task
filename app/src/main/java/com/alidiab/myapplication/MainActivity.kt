package com.alidiab.myapplication

import android.content.DialogInterface
import android.content.Intent
 import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import com.alidiab.myapplication.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var postList: ArrayList<Post>
    private lateinit var postAdapter: PostAdapter
    private lateinit var biding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        biding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(biding.root)

        biding.loginButton.setOnClickListener {

            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }
    }


}