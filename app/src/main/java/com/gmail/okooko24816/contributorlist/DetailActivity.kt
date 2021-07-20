package com.gmail.okooko24816.contributorlist

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.AsyncTask
import android.widget.Button
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.gmail.okooko24816.contributorlist.adapter.DetailAdapter
import java.io.IOException
import java.io.InputStream
import java.net.MalformedURLException
import java.net.URL
import java.util.*


class DetailActivity : AppCompatActivity(){
    val contributors:MutableList<Contributor>? = mutableListOf<Contributor>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val finish_button = findViewById<Button>(R.id.finish)
        finish_button.setOnClickListener(){
            finish()
        }
    }

    override fun onStart(){
        super.onStart()
        val recyclerView:RecyclerView = findViewById(R.id.detail_list)
        val intent:Intent = intent
        val position:Int = intent.getIntExtra("position",10000)
        if(position == 10000){
          for(i in 0 until MyApplication.contributors!!.size){
              contributors?.add(MyApplication.contributors!!.get(i))
          }
        }else{
            contributors?.add(MyApplication.contributors!!.get(position))
        }
        val layoutManager = LinearLayoutManager(applicationContext)
        val adapter:DetailAdapter = DetailAdapter(this,contributors)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter
    }
}