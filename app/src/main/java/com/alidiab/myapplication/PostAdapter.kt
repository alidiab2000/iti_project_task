package com.alidiab.myapplication

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alidiab.myapplication.databinding.PostItemBinding
import com.squareup.picasso.Picasso

class PostAdapter (private  val postList : ArrayList<Post>):
    RecyclerView.Adapter<PostAdapter.PostViewHolder>() {
   inner class PostViewHolder(val biding : PostItemBinding):RecyclerView.ViewHolder(biding.root)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
       val biding = PostItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
       return PostViewHolder(biding)
    }
    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val post = postList[position]
        holder.biding.usernamePost.text = post.userName
        holder.biding.postbody.text = post.postBody
        holder.biding.postdate.text = post.postDate
        if(post.imageUrl.isNotEmpty()){
            Picasso.get()
                .load(post.imageUrl)
                .into(holder.biding.profileImage)
        }

    }
    override fun getItemCount(): Int {
        return postList.size
    }
}