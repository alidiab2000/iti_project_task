package com.alidiab.myapplication


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
import com.alidiab.myapplication.databinding.ActivitySecondBinding
import com.alidiab.myapplication.model.Post
import com.alidiab.myapplication.utils.ApiInterface
import com.alidiab.myapplication.utils.MyCustomClickListener

import com.alidiab.myapplication.utils.RetrofitClient


class SecondActivity : AppCompatActivity() , MyCustomClickListener {
    private lateinit var postList :List<Post>
    private lateinit var postAdapter: PostAdapter
    private lateinit var sharedpref: SharedPreferences
    private lateinit var biding: ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        biding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(biding.root)
        sharedpref = applicationContext.getSharedPreferences("UserPref", Context.MODE_PRIVATE)
        biding.recycler.setHasFixedSize(true)
        biding.recycler.layoutManager = LinearLayoutManager(this)
/*=============================================================================================*/
        biding.BTSelect.setOnClickListener{
            val retrofit = RetrofitClient.getInstance().create(ApiInterface::class.java)
            lifecycleScope.launchWhenCreated {
                val response  =  retrofit.getUserFromId(biding.edUserId.text.toString().toInt())
                if(response.isSuccessful){
                    postList = response.body()!!
                    postAdapter = PostAdapter(postList , this@SecondActivity)
                    biding.recycler.adapter = postAdapter
                }else{
                    Toast.makeText(this@SecondActivity , "Error ",Toast.LENGTH_LONG).show()
                }
            }
        }


    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main_activity, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.logout -> {
                val editor = sharedpref.edit()
                editor.remove("UserName")
                editor.remove("PassWord")
                editor.putBoolean("login", false)
                editor.commit()
                startActivity(Intent(this, MainActivity::class.java))
                finish()
                return true
            }

            else -> return super.onOptionsItemSelected(item)
        }
    }

    override fun onItemClick(post: Post, position: Int) {
         val intent = Intent(this@SecondActivity ,ThirdActivity::class.java )
         intent.putExtra("postId", post.id)

         startActivity(intent)
    }

}