package com.gmail.okooko24816.contributorlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.gmail.okooko24816.contributorlist.adapter.MainAdapter
import kotlinx.serialization.json.Json
import kotlinx.serialization.parse
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
    override fun onStart(){
        super.onStart()
        val recyclerView = findViewById<RecyclerView>(R.id.contributor_names)
        val layoutManager = LinearLayoutManager(applicationContext)
        val adapter = MainAdapter(this,MyApplication.contributors)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter
        if(MyApplication.contributors == null){
            MyApplication.setContributors(MyApplication.contributors,MyApplication.str)
        }
    }
}
