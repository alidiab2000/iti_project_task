@file:Suppress("DEPRECATION")

package com.alidiab.myapplication.UI.Second


import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.alidiab.myapplication.Adapters.PostAdapter
import com.alidiab.myapplication.R
import com.alidiab.myapplication.UI.Login.LoginActivity
import com.alidiab.myapplication.databinding.ActivitySecondBinding
import com.alidiab.myapplication.core.model.Post

import com.alidiab.myapplication.core.data_source.remote.RetrofitClient
import com.alidiab.myapplication.screen.MyCustomClickListener
import com.alidiab.myapplication.screen.ThirdActivity


class MainActivity : AppCompatActivity() , MyCustomClickListener {
     private lateinit var postList :List<Post>
     private lateinit var postAdapter: PostAdapter
     private lateinit var binding: ActivitySecondBinding
     private lateinit var viewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        binding.recycler.setHasFixedSize(true)
//        binding.recycler.layoutManager = LinearLayoutManager(this)
        binding.BTSelect.setOnClickListener{
          viewModel.getUserByID(binding.edUserId.text.toString().toInt())
        }

        viewModel = MainViewModel(context = this , listener = this, binding = binding)
        viewModel.userByIdData.observe(this){
//            postList = viewModel.userByIdData.value?.body()!!
//            postAdapter = PostAdapter(postList , this@MainActivity)
//            binding.recycler.adapter = postAdapter
            viewModel.mainAdapter()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main_activity, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.logout -> {
                viewModel.repo.logOut()
                startActivity(Intent(this, LoginActivity::class.java))
                finish()
                return true
            }

            else -> return super.onOptionsItemSelected(item)
        }
    }

    override fun onItemClick(post: Post, position: Int) {
         val intent = Intent(this@MainActivity , ThirdActivity::class.java )
         intent.putExtra("postId", post.id)
         startActivity(intent)
    }

}