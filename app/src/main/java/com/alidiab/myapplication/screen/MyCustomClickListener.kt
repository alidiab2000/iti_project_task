package com.alidiab.myapplication.screen

import com.alidiab.myapplication.core.model.Post

interface MyCustomClickListener {

    fun onItemClick(post: Post, position:Int)
}