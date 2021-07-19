package com.gmail.okooko24816.contributorlist

import android.app.Application
import android.content.res.AssetManager
import android.util.Log
import android.widget.Toast
import kotlinx.serialization.json.Json
import kotlinx.serialization.parse
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader

class MyApplication : Application() {
    companion object{
        lateinit var assetManager: AssetManager
        lateinit var inputStream: InputStream
        lateinit var bufferReader: BufferedReader
        lateinit var str:String
        var contributors:MutableList<Contributor>? = mutableListOf<Contributor>()

        fun setContributors(_contributors:MutableList<Contributor>?,_str:String){
            try{
                val jsonArray = JSONArray(_str)
                for(i in 0 until jsonArray.length()){
                    var jsonData = jsonArray.getJSONObject(i)
                    var login = jsonData.getString("login")
                    var id = jsonData.getString("id")
                    Log.d("Check","$login,$id")
                    val contributor = Contributor(
                        jsonData.getString("login"),
                        jsonData.getString("id"),
                        jsonData.getString("node_id"),
                        jsonData.getString("avatar_url"),
                        jsonData.getString("gravatar_id"),
                        jsonData.getString("url"),
                        jsonData.getString("html_url"),
                        jsonData.getString("followers_url"),
                        jsonData.getString("following_url"),
                        jsonData.getString("gists_url"),
                        jsonData.getString("starred_url"),
                        jsonData.getString("subscriptions_url"),
                        jsonData.getString("organizations_url"),
                        jsonData.getString("repos_url"),
                        jsonData.getString("events_url"),
                        jsonData.getString("received_events_url"),
                        jsonData.getString("type"),
                        jsonData.getString("site_admin"),
                        jsonData.getString("contributions")
                    )
                    _contributors?.add(contributor)
                }
                Log.d("Count","${_contributors?.size}")
            }catch(e:JSONException){
                e.printStackTrace()
            }
        }
    }


    override fun onCreate(){
        super.onCreate()
        //resourceはoncreateの前は読まれない
        assetManager = resources.assets
        inputStream = assetManager.open("json/contributors.json")
        bufferReader = BufferedReader(InputStreamReader(inputStream))
        str = bufferReader.readText()

            try{
                val jsonArray = JSONArray(str)
                for(i in 0 until jsonArray.length()){
                    var jsonData = jsonArray.getJSONObject(i)
                    var login = jsonData.getString("login")
                    var id = jsonData.getString("id")
                    Log.d("Check","$login,$id")
                    val contributor = Contributor(
                        jsonData.getString("login"),
                        jsonData.getString("id"),
                        jsonData.getString("node_id"),
                        jsonData.getString("avatar_url"),
                        jsonData.getString("gravatar_id"),
                        jsonData.getString("url"),
                        jsonData.getString("html_url"),
                        jsonData.getString("followers_url"),
                        jsonData.getString("following_url"),
                        jsonData.getString("gists_url"),
                        jsonData.getString("starred_url"),
                        jsonData.getString("subscriptions_url"),
                        jsonData.getString("organizations_url"),
                        jsonData.getString("repos_url"),
                        jsonData.getString("events_url"),
                        jsonData.getString("received_events_url"),
                        jsonData.getString("type"),
                        jsonData.getString("site_admin"),
                        jsonData.getString("contributions")
                        )
                    contributors?.add(contributor)
                }
                //contributors.
        }catch(e:JSONException){
            e.printStackTrace()
        }
        Log.d("Count","${contributors?.size}")
    }
}