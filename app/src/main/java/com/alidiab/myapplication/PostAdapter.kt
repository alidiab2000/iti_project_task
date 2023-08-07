package com.alidiab.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PostAdapter (private  val postList : ArrayList<Post>):
    RecyclerView.Adapter<PostAdapter.PostViewHolder>() {
    class PostViewHolder(itemView : View):RecyclerView.ViewHolder(itemView) {
          val username :TextView  = itemView.findViewById(R.id.usernamePost)
          val postDate :TextView  = itemView.findViewById(R.id.postdate)
          val postBody :TextView  = itemView.findViewById(R.id.postbody)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
       val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list,parent,false)
       return PostViewHolder(view)
    }

    override fun getItemCount(): Int {
        return postList.size
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val post = postList[position]
        holder.username.text = post.userName
        holder.postBody.text = post.postBody
        holder.postDate.text = post.postDate

    }

}