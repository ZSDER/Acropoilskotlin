package com.example.acropoilskotlinproject.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.acropoilskotlinproject.R
import com.example.acropoilskotlinproject.view.model.AppsModel
import com.example.acropoilskotlinproject.view.model.Category

class AppsAdapter (val appsModellist: ArrayList<AppsModel>) : RecyclerView.Adapter<AppsAdapter.AppsViewHolder>() {

    var count: Int = 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AppsViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.layout_apps, parent, false)
        return AppsViewHolder(v)
    }

    override fun onBindViewHolder(holder: AppsViewHolder, position: Int) {
        val appsModel = appsModellist[position]
        holder.names.text = appsModel.title
        holder.appimg.setImageResource(appsModel.appsimage)
        holder.likeunlike.setImageResource(appsModel.likeimg)

        holder.likeunlike.setOnClickListener(View.OnClickListener {
            if (count == 0){
                holder.likeunlike.setImageResource(R.drawable.ic_action_like)
                holder.likeunlike.setColorFilter(R.color.purple_500)
                count = 1
            } else if (count == 1){
                holder.likeunlike.setImageResource(R.drawable.ic_action_unlike)
                holder.likeunlike.setColorFilter(R.color.darkgray)
                count = 0
            }
        })

    }

    override fun getItemCount(): Int {
        return appsModellist.size
    }

    class AppsViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView)  {
        var names : TextView = itemView.findViewById(R.id.name)
        var likeunlike: ImageView = itemView.findViewById(R.id.like_unlike_img)
        var appimg: ImageView = itemView.findViewById(R.id.apps_image)

    }

}