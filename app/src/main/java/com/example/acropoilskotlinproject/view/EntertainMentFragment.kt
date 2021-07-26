package com.example.acropoilskotlinproject.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.acropoilskotlinproject.R
import com.example.acropoilskotlinproject.view.adapter.CustomAdapter
import com.example.acropoilskotlinproject.view.adapter.EntertainMentAdapter
import com.example.acropoilskotlinproject.view.model.Category
import com.example.acropoilskotlinproject.view.model.EntertainMentModel


class EntertainMentFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_entertain_ment, container, false)

        val recyclerView = view.findViewById(R.id.entertainMentcyclerView) as RecyclerView

        //adding a layoutmanager
        recyclerView.layoutManager = LinearLayoutManager(context)


        //crating an arraylist to store users using the data class user
        val users = ArrayList<EntertainMentModel>()

        //adding some dummy data to the list
        users.add(EntertainMentModel(R.drawable.movies,"Movies",R.drawable.ic_action_like))
        users.add(EntertainMentModel(R.drawable.music,"Music",R.drawable.ic_action_like))
        users.add(EntertainMentModel(R.drawable.videogame,"Video Game",R.drawable.ic_action_like))


        //creating our adapter
        val adapter = EntertainMentAdapter(users)

        //now adding the adapter to recyclerview
        recyclerView.adapter = adapter

        return view
    }

}