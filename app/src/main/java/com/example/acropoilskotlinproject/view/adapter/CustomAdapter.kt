package com.example.acropoilskotlinproject.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.acropoilskotlinproject.R
import com.example.acropoilskotlinproject.view.model.Category

class CustomAdapter (val categorlist: ArrayList<Category>) : RecyclerView.Adapter<CustomAdapter.CustomViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.layout_home, parent, false)
        return CustomViewHolder(v)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val category = categorlist[position]
        holder.categorys.text = category.catName
        holder.itemView.setOnClickListener(View.OnClickListener {
            if (category.catName.equals("Entertainment")){
                Navigation.findNavController(it).navigate(R.id.action_homeFragment_to_entertainMentFragment)
            } else if (category.catName.equals("Books")){
                Navigation.findNavController(it).navigate(R.id.action_homeFragment_to_bookFragment)
            }else if (category.catName.equals("Apps")){
                Navigation.findNavController(it).navigate(R.id.action_homeFragment_to_appsFragment)
            }

        })
    }

    override fun getItemCount(): Int {
        return categorlist.size
    }

    class CustomViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {
        var categorys: TextView = itemView.findViewById(R.id.category)

    }
}