package com.alidiab.myapplication

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alidiab.myapplication.databinding.UserItemBinding
import com.alidiab.myapplication.model.User
import com.squareup.picasso.Picasso

class UserAdapter (private  val userList : List<User>  ):
    RecyclerView.Adapter<UserAdapter.PostViewHolder>() {
    inner class PostViewHolder(val biding : UserItemBinding):RecyclerView.ViewHolder(biding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val biding = UserItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return PostViewHolder(biding)

    }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val user = userList[position]
        holder.biding.usernamePost.text = user.firstName
        holder.biding.email.text = user.email
        holder.biding.userId.text = user.id.toString()
        if(user.avatar?.isNotEmpty()!!){
            Picasso.get()
                .load(user.avatar)
                .into(holder.biding.profileImage)
        }


    }

}