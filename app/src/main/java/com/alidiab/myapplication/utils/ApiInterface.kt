package com.alidiab.myapplication.utils

import com.alidiab.myapplication.model.Comment
import com.alidiab.myapplication.model.Post
 import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface ApiInterface {
    @GET("posts")
   suspend fun getAllUser():Response<List<Post>>

   @GET("posts")
   suspend fun getUserFromId(@Query("userId") userId :Int) :Response<List<Post>>
    @GET("posts/{postId}/comments")
    suspend fun getComments(@Path("postId") postId:Int) :Response<List<Comment>>

}
