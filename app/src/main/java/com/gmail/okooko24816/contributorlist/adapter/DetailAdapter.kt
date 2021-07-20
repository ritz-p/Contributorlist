package com.gmail.okooko24816.contributorlist.adapter

import android.app.Application
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.AsyncTask
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.URLUtil
import android.widget.ImageView
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.gmail.okooko24816.contributorlist.*
import kotlinx.android.synthetic.main.item_detail.view.*
import kotlinx.android.synthetic.main.item_main.view.*
import java.io.IOException
import java.io.InputStream
import java.net.URL

class DetailAdapter(val context: Context,contributors:MutableList<Contributor>?): RecyclerView.Adapter<DetailAdapter.DetailViewHolder>(){

    val contributors:MutableList<Contributor>? = contributors
    class DetailViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val login = itemView.login_text
        val id = itemView.id_text
        val node_id = itemView.node_id_text
        val avatar = itemView.avatar
        val gravatar = itemView.gravatar_id_text
        val url = itemView.url_button
        val html_url = itemView.html_url_button
        val followers_url = itemView.followers_url_button
        val following_url = itemView.following_url_button
        val gists_url = itemView.gists_url_button
        val starred_url = itemView.starred_url_button
        val subscriptions_url = itemView.subscriptions_url_button
        val organizations_url = itemView.organizations_url_button
        val repos_url = itemView.repos_url_button
        val events_url = itemView.events_url_button
        val received_events_url = itemView.received_events_url_button
        val type = itemView.type_text
        val site_admin = itemView.site_admin_text
        val contributions = itemView.contributions_text
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.item_detail,parent,false)
        return DetailViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: DetailViewHolder, position: Int) {
        val item = contributors?.get(position)
        holder.login.text = item?.login
        holder.id.text = item?.id
        holder.node_id.text = item?.node_id
        holder.type.text = item?.type
        holder.site_admin.text = item?.site_admin
        holder.contributions.text = item?.contributions
        holder.gravatar.text = item?.gravatar_id

        holder.url.text = item?.url
        holder.url.setOnClickListener(){
            GoToBlowser(item?.url,holder.url)
        }

        holder.html_url.text = item?.html_url
        holder.html_url.setOnClickListener(){
            GoToBlowser(item?.html_url,holder.html_url)
        }

        holder.followers_url.text = item?.follower_url
        holder.followers_url.setOnClickListener(){
            GoToBlowser(item?.follower_url,holder.followers_url)
        }

        holder.following_url.text = item?.following_url
        holder.following_url.setOnClickListener(){
            GoToBlowser(item?.following_url,holder.following_url)
        }

        holder.gists_url.text = item?.gists_url
        holder.gists_url.setOnClickListener(){
            GoToBlowser(item?.gists_url,holder.gists_url)
        }

        holder.starred_url.text = item?.starred_url
        holder.starred_url.setOnClickListener(){
            GoToBlowser(item?.starred_url,holder.starred_url)
        }

        holder.subscriptions_url.text = item?.subscriptions_url
        holder.subscriptions_url.setOnClickListener(){
            GoToBlowser(item?.subscriptions_url,holder.subscriptions_url)
        }

        holder.organizations_url.text = item?.organizations_url
        holder.organizations_url.setOnClickListener(){
            GoToBlowser(item?.organizations_url,holder.organizations_url)
        }

        holder.repos_url.text = item?.repos_url
        holder.repos_url.setOnClickListener(){
            GoToBlowser(item?.repos_url,holder.repos_url)
        }

        holder.events_url.text = item?.events_url
        holder.events_url.setOnClickListener(){
            GoToBlowser(item?.events_url,holder.events_url)
        }

        holder.received_events_url.text = item?.received_events_url
        holder.received_events_url.setOnClickListener(){
            GoToBlowser(item?.received_events_url,holder.received_events_url)
        }

        val imageTask:GetImageTask = GetImageTask(holder.avatar)
        imageTask.execute(item?.avatar_url)
    }

    override fun getItemCount(): Int {
        if (contributors != null) {
            return contributors.size
        }
        return 0
    }

    internal inner class GetImageTask(private val image: ImageView) :
        AsyncTask<String, Void, Bitmap>() {
        override fun doInBackground(vararg params: String): Bitmap? {
            val image: Bitmap
            val defaultImage = BitmapFactory.decodeStream(MyApplication.assetManager.open("image/powered_fox_girl.png"))
            try {
                val imageUrl = URL(params[0])
                val imageIs: InputStream
                imageIs = imageUrl.openStream()
                image = BitmapFactory.decodeStream(imageIs)
                return image
            }  catch (e: IOException) {
                //画像が取れない時用
                return defaultImage
            }

        }

        override fun onPostExecute(result: Bitmap) {
            // 取得した画像をImageViewに設定します。
            image.setImageBitmap(result)
        }
    }

    fun GoToBlowser(url:String?,view:View){
        if(URLUtil.isValidUrl(url)) {
            val uri: Uri = Uri.parse(url)
            val intent = Intent(Intent.ACTION_VIEW, uri)
            view.context.startActivity(intent)
        }else{
            Toast.makeText(view.context,"URL is Invalid",Toast.LENGTH_SHORT).show()
        }
    }

}