@file:Suppress("DEPRECATION")

package com.alidiab.myapplication

import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.alidiab.myapplication.Adapters.CommentAdapter

import com.alidiab.myapplication.databinding.ActivityThirdBinding
import com.alidiab.myapplication.model.Comment
import com.alidiab.myapplication.utils.ApiInterface
import com.alidiab.myapplication.utils.RetrofitClient

class ThirdActivity :AppCompatActivity(){
    private lateinit var binding: ActivityThirdBinding
    private lateinit var commentList: List<Comment>
    private lateinit var commentAdapter: CommentAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityThirdBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val postID = intent.extras?.getInt("postId",1)
        val retrofit = RetrofitClient.getInstance().create(ApiInterface::class.java)
        lifecycleScope.launchWhenCreated {
            val response = retrofit.getComments(postID!!)
            commentList = response.body()!!
            commentAdapter = CommentAdapter(commentList)
            binding.recycler1.adapter = commentAdapter
        }
    }

}