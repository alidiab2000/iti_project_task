package com.alidiab.myapplication.utils

import com.alidiab.myapplication.model.ResponseUserList
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {
    @GET("users")
   suspend fun getAllUser():Response<ResponseUserList>
}
