package com.alidiab.myapplication.core.data_source.remote

import com.alidiab.myapplication.core.model.Comment
import com.alidiab.myapplication.core.model.body.LoginRequest
import com.alidiab.myapplication.core.model.Post
import com.alidiab.myapplication.core.model.response.UserResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query


interface ApiInterface {
    @GET("posts")
   suspend fun getAllUser():Response<List<Post>>

   @GET("posts")
   suspend fun getUserFromId(@Query("userId") userId :Int) :Response<List<Post>>
    @GET("posts/{postId}/comments")
    suspend fun getComments(@Path("postId") postId:Int) :Response<List<Comment>>
    @POST("auth/login")
    suspend fun login(@Body body: LoginRequest):Response<UserResponse>

}
