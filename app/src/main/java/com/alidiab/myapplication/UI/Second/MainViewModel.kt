package com.alidiab.myapplication.UI.Second

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.alidiab.myapplication.Adapters.PostAdapter
import com.alidiab.myapplication.core.model.Post
import com.alidiab.myapplication.core.repo.MainRepo
import com.alidiab.myapplication.databinding.ActivitySecondBinding
import com.alidiab.myapplication.screen.MyCustomClickListener
import kotlinx.coroutines.launch


import retrofit2.Response

class MainViewModel(val context: Context ,val binding: ActivitySecondBinding , val listener: MyCustomClickListener ):ViewModel()  {
    val userByIdData : MutableLiveData<Response<List<Post>>> = MutableLiveData()
    val repo = MainRepo(context)
    fun getUserByID(id :Int){
         viewModelScope.launch {
             userByIdData.postValue(repo.getUserFromID(id))
         }
    }
    fun mainAdapter(){
        binding.recycler.setHasFixedSize(true)
        binding.recycler.layoutManager = LinearLayoutManager(context)
        val postList = userByIdData.value?.body()!!
        val postAdapter = PostAdapter(postList ,listener)
        binding.recycler.adapter = postAdapter
    }


}