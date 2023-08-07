package com.alidiab.myapplication


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.alidiab.myapplication.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
     private lateinit var recyclerView: RecyclerView
     private lateinit var postList :ArrayList<Post>
     private lateinit var postAdapter: PostAdapter
     private lateinit var biding : ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        biding = ActivitySecondBinding .inflate(layoutInflater)
        setContentView(biding.root)
        recyclerView = findViewById(R.id.recycler)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)

        postList = ArrayList()
        postList.add(Post("AliDaib" , "10/2/2003","Welcome my name is ali diab"))
        postList.add(Post("Ahmed" , "10/2/2003","Welcome my name is Ahmed"))
        postList.add(Post("fady" , "10/2/2003","Welcome my name is fady"))
        postList.add(Post(" Daib" , "10/2/2003","Welcome my name is  diab"))
        postList.add(Post("Ali " , "10/2/2003","Welcome my name is ali"))
        postList.add(Post("Radwa" , "10/2/2003","Welcome my name is Radwa"))
        postList.add(Post("Reda" , "10/2/2003","Welcome my name is Reda"))
        postAdapter = PostAdapter(postList)
        recyclerView.adapter = postAdapter

    }
}