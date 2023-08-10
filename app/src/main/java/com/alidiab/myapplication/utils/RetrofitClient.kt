package com.alidiab.myapplication.utils
import com.google.gson.Gson
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
 fun getInstance():Retrofit{
     val interceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
     val okHttpClient = OkHttpClient.Builder().addInterceptor(interceptor).build()
     val retrofit :Retrofit = Retrofit.Builder()
         .baseUrl("https://reqres.in/api/")
         .addConverterFactory(GsonConverterFactory.create())
         .client(okHttpClient)
         .build()
     return retrofit
 }

}
