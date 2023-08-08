package com.alidiab.myapplication


import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
 import com.alidiab.myapplication.databinding.ActivitySecondBinding
import com.alidiab.myapplication.databinding.PostItemBinding

class SecondActivity : AppCompatActivity() {


     private lateinit var postAdapter: PostAdapter
     private lateinit var biding : ActivitySecondBinding
     private lateinit var bidingTh : PostItemBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        biding = ActivitySecondBinding .inflate(layoutInflater)
        setContentView(biding.root)
        biding.recycler.setHasFixedSize(true)
        biding.recycler.layoutManager = LinearLayoutManager(this)

       val postList = ArrayList<Post>()
        postList.add(Post("AliDaib" , "10/2/2003","Welcome my name is ali diab", imageUrl = imageLink))
        postList.add(Post("Ahmed"   , "10/2/2003","Welcome my name is Ahmed", imageUrl = imageLink))
        postList.add(Post("fady"    , "10/2/2003","Welcome my name is fady",imageUrl = imageLink))
        postList.add(Post("Daib"   ,  "10/2/2003","Welcome my name is  diab",imageUrl = imageLink))
        postList.add(Post("Ali"     , "10/2/2003","Welcome my name is ali",imageUrl = imageLink))
        postList.add(Post("Radwa"   , "10/2/2003","Welcome my name is Radwa",imageUrl = imageLink))
        postList.add(Post("Reda"     ,"10/2/2003","Welcome my name is Reda",imageUrl = imageLink))
        postList.add(Post("AliDaib" , "10/2/2003","Welcome my name is ali diab", imageUrl = imageLink))
        postList.add(Post("Ahmed"   , "10/2/2003","Welcome my name is Ahmed", imageUrl = imageLink))
        postList.add(Post("fady"    , "10/2/2003","Welcome my name is fady",imageUrl = imageLink))
        postList.add(Post("Daib"   ,  "10/2/2003","Welcome my name is  diab",imageUrl = imageLink))
        postList.add(Post("Ali"     , "10/2/2003","Welcome my name is ali",imageUrl = imageLink))
        postList.add(Post("Radwa"   , "10/2/2003","Welcome my name is Radwa",imageUrl = imageLink))
        postList.add(Post("Reda"     ,"10/2/2003","Welcome my name is Reda",imageUrl = imageLink))

        postAdapter = PostAdapter(postList)
        biding.recycler.adapter = postAdapter

    }
}