package com.example.acropoilskotlinproject.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.acropoilskotlinproject.R
import com.example.acropoilskotlinproject.view.model.AppsModel
import com.example.acropoilskotlinproject.view.model.BookModel

class BookAdapter (val bookModellist: ArrayList<BookModel>) : RecyclerView.Adapter<BookAdapter.BookViewHolder>() {

    var count: Int = 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.layout_book, parent, false)
        return BookViewHolder(v)
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        val bookModel = bookModellist[position]
        holder.names.text = bookModel.title
        holder.bookimg.setImageResource(bookModel.bookModelModelimage)
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
        return bookModellist.size
    }

    class BookViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView)  {
        var names : TextView = itemView.findViewById(R.id.name)
        var likeunlike: ImageView = itemView.findViewById(R.id.like_unlike_img)
        var bookimg: ImageView = itemView.findViewById(R.id.book_image)

    }

}
