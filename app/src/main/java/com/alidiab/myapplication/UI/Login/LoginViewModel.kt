@file:Suppress("PackageName")
package com.alidiab.myapplication.UI.Login
import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alidiab.myapplication.core.model.response.UserResponse
import com.alidiab.myapplication.core.repo.LoginRepo
import com.alidiab.myapplication.databinding.ActivityMainBinding
import kotlinx.coroutines.launch
import retrofit2.Response

class LoginViewModel(context :Context , binding: ActivityMainBinding) : ViewModel() {
  val loginData : MutableLiveData<Response<UserResponse>> = MutableLiveData()
    private val repo = LoginRepo(context , binding)
     fun startLogin(username:String , password :String){
         viewModelScope.launch {
            loginData.postValue(repo.login(username,password))
         }
  }
}