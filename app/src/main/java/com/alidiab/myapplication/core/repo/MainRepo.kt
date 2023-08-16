package com.alidiab.myapplication.core.repo

import android.content.Context
import android.content.SharedPreferences
 import com.alidiab.myapplication.core.data_source.remote.RetrofitClient
import com.alidiab.myapplication.core.model.Post
import com.alidiab.myapplication.databinding.ActivitySecondBinding
import retrofit2.Response

class MainRepo(private val context: Context  ) {
    val retrofit = RetrofitClient.getInstance("https://jsonplaceholder.typicode.com/")
    private lateinit var sharedpref: SharedPreferences
   suspend fun getUserFromID(id:Int): Response<List<Post>> {
       sharedpref = context.getSharedPreferences("UserPref", Context.MODE_PRIVATE)
       return retrofit.getUserFromId(id)
   }
    fun logOut(){
        val editor = sharedpref.edit()
        editor.remove("UserName")
        editor.remove("PassWord")
        editor.putBoolean("login", false)
        editor.apply()
    }

}