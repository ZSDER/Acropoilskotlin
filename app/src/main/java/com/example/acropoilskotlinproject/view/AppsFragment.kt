package com.example.acropoilskotlinproject.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.acropoilskotlinproject.R
import com.example.acropoilskotlinproject.view.adapter.AppsAdapter
import com.example.acropoilskotlinproject.view.adapter.EntertainMentAdapter
import com.example.acropoilskotlinproject.view.model.AppsModel
import com.example.acropoilskotlinproject.view.model.EntertainMentModel

class AppsFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View =  inflater.inflate(R.layout.fragment_apps, container, false)

        val recyclerView = view.findViewById(R.id.appsrecyclerView) as RecyclerView

        //adding a layoutmanager
        recyclerView.layoutManager = LinearLayoutManager(context)


        //crating an arraylist to store users using the data class user
        val users = ArrayList<AppsModel>()

        //adding some dummy data to the list
        users.add(AppsModel(R.drawable.filpkat,"Flipkart",R.drawable.ic_action_like))
        users.add(AppsModel(R.drawable.myntra,"Myntra",R.drawable.ic_action_like))
        users.add(AppsModel(R.drawable.amazon,"Amozon",R.drawable.ic_action_like))


        //creating our adapter
        val adapter = AppsAdapter(users)

        //now adding the adapter to recyclerview
        recyclerView.adapter = adapter

        return view
    }


}