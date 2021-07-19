package com.gmail.okooko24816.contributorlist.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gmail.okooko24816.contributorlist.Contributor
import com.gmail.okooko24816.contributorlist.R
import kotlinx.android.synthetic.main.item_main.view.*

class MainAdapter(val context: Context,contributors:MutableList<Contributor>?): RecyclerView.Adapter<MainAdapter.MainViewHolder>(){

    val contributors:MutableList<Contributor>? = contributors
    class MainViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val contributor_button = itemView.contributor_button
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.item_main,parent,false)
        return MainViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val item = contributors?.get(position)
        //button text を contributor の名前に
        holder.contributor_button.text = item?.login
    }

    override fun getItemCount(): Int {
        if (contributors != null) {
            return contributors.size
        }
        return 0
    }

}