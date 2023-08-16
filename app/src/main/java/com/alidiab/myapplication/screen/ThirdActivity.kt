@file:Suppress("DEPRECATION")

package com.alidiab.myapplication.screen

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.alidiab.myapplication.Adapters.CommentAdapter

import com.alidiab.myapplication.databinding.ActivityThirdBinding
import com.alidiab.myapplication.core.model.Comment
import com.alidiab.myapplication.core.data_source.remote.ApiInterface
import com.alidiab.myapplication.core.data_source.remote.RetrofitClient

class ThirdActivity :AppCompatActivity(){
    private lateinit var binding: ActivityThirdBinding
    private lateinit var commentList: List<Comment>
    private lateinit var commentAdapter: CommentAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityThirdBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val postID = intent.extras?.getInt("postId",1)
        val retrofit = RetrofitClient.getInstance("https://jsonplaceholder.typicode.com/")
        lifecycleScope.launchWhenCreated {
            val response = retrofit.getComments(postID!!)
            commentList = response.body()!!
            commentAdapter = CommentAdapter(commentList)
            binding.recycler1.layoutManager = LinearLayoutManager(this@ThirdActivity)
            binding.recycler1.adapter = commentAdapter
        }
    }

}