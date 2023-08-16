package com.alidiab.myapplication.core.repo

import android.content.Context
import android.content.SharedPreferences
import android.content.Context.MODE_PRIVATE
import com.alidiab.myapplication.core.data_source.remote.RetrofitClient
import com.alidiab.myapplication.core.model.body.LoginRequest
import com.alidiab.myapplication.core.model.response.UserResponse
import com.alidiab.myapplication.databinding.ActivityMainBinding
import retrofit2.Response

class LoginRepo(private val context: Context, private val binding: ActivityMainBinding) {
    private val retrofit = RetrofitClient.getInstance("https://dummyjson.com/")

    suspend fun login(userName: String, password: String): Response<UserResponse> {
        sharedPref()
        return retrofit.login(LoginRequest(userName, password))
    }
    private fun sharedPref(){
        val sharedPreferences: SharedPreferences = context.getSharedPreferences("UserPref", MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putString("UserName" , binding.editTextUsername.text.toString())
        editor.putString("PassWord" , binding.editPass.text.toString())
        editor.putBoolean("login" , true)
        editor.apply()
    }
}
