package com.alidiab.myapplication.utils

import com.alidiab.myapplication.model.Post

interface MyCustomClickListener {

    fun onItemClick(post:Post , position:Int)
}