package com.alidiab.myapplication.core.data_source.remote
import com.google.gson.Gson
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    //"https://jsonplaceholder.typicode.com/"
 fun getInstance(baseUrl:String):ApiInterface{
     val interceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
     val okHttpClient = OkHttpClient.Builder().addInterceptor(interceptor).build()
     val retrofit : ApiInterface = Retrofit.Builder()
         .baseUrl(baseUrl)
         .addConverterFactory(GsonConverterFactory.create())
         .client(okHttpClient)
         .build().create(ApiInterface::class.java)
     return retrofit
 }
}
