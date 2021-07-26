package com.example.acropoilskotlinproject.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.acropoilskotlinproject.R
import com.example.acropoilskotlinproject.view.model.BookModel
import com.example.acropoilskotlinproject.view.model.EntertainMentModel


class EntertainMentAdapter (val entertainmentModellist: ArrayList<EntertainMentModel>) : RecyclerView.Adapter<EntertainMentAdapter.EntertainMentViewHolder>() {

    var count: Int = 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EntertainMentViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.layout_entertainment, parent, false)
        return EntertainMentViewHolder(v)
    }

    override fun onBindViewHolder(holder: EntertainMentViewHolder, position: Int) {
        val bookModel = entertainmentModellist[position]
        holder.names.text = bookModel.title
        holder.entertainimg.setImageResource(bookModel.entertainmentModelimage)
        holder.likeunlike.setImageResource(bookModel.likeimg)
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
        return entertainmentModellist.size
    }

    class EntertainMentViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView)  {
        var names : TextView = itemView.findViewById(R.id.name)
        var likeunlike: ImageView = itemView.findViewById(R.id.like_unlike_img)
        var entertainimg: ImageView = itemView.findViewById(R.id.entertain_image)

    }

}

