package com.alidiab.myapplication.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alidiab.myapplication.databinding.CommentItemBinding

import com.alidiab.myapplication.model.Comment


class CommentAdapter (private  val commentList : List<Comment>  ):
    RecyclerView.Adapter<CommentAdapter.CommentViewHolder>() {
    inner class CommentViewHolder(val biding : CommentItemBinding):RecyclerView.ViewHolder(biding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentViewHolder {
        val biding = CommentItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return CommentViewHolder(biding)

    }

    override fun getItemCount(): Int {
        return commentList.size
    }

    override fun onBindViewHolder(holder: CommentViewHolder, position: Int) {
       val comment = commentList[position]
        holder.biding.postId.text = "Post ID :${comment.postId.toString()}"
        holder.biding.commentid.text = comment.id.toString()
        holder.biding.name.text = comment.name.toString()
        holder.biding.email.text = comment.email.toString()
        holder.biding.body.text = comment.body.toString()


    }

}