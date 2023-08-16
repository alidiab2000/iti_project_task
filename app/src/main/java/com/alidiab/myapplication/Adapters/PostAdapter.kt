package com.alidiab.myapplication.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alidiab.myapplication.screen.MyCustomClickListener
import com.alidiab.myapplication.databinding.PostItemBinding
import com.alidiab.myapplication.core.model.Post


class PostAdapter (private  val postList : List<Post>, val listener: MyCustomClickListener):
    RecyclerView.Adapter<PostAdapter.PostViewHolder>() {
    inner class PostViewHolder(val biding : PostItemBinding):RecyclerView.ViewHolder(biding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val biding = PostItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return PostViewHolder(biding)

    }

    override fun getItemCount(): Int {
        return postList.size
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val post = postList[position]
        holder.biding.userIdPost.text = "UserID : ${post.userId.toString()}"
        holder.biding.postId.text = "PostID : ${post.id.toString()}"
        holder.biding.title.text = post.title.toString()
        holder.biding.body.text = post.body.toString()
        holder.biding.thirdbt.setOnClickListener{
            listener.onItemClick(post, position)
        }
    }

}