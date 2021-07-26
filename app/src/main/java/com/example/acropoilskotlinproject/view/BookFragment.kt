package com.example.acropoilskotlinproject.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.acropoilskotlinproject.R
import com.example.acropoilskotlinproject.view.adapter.BookAdapter
import com.example.acropoilskotlinproject.view.adapter.EntertainMentAdapter
import com.example.acropoilskotlinproject.view.model.BookModel
import com.example.acropoilskotlinproject.view.model.EntertainMentModel


class BookFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_book, container, false)

        val recyclerView = view.findViewById(R.id.bookrecyclerView) as RecyclerView

        //adding a layoutmanager
        recyclerView.layoutManager = LinearLayoutManager(context)


        //crating an arraylist to store users using the data class user
        val users = ArrayList<BookModel>()

        //adding some dummy data to the list
        users.add(BookModel(R.drawable.invisibleman,"Invisible Man",R.drawable.ic_action_like))
        users.add(BookModel(R.drawable.donquixote,"Don Quixote",R.drawable.ic_action_like))
        users.add(BookModel(R.drawable.passagetoindia,"A Passage to India",R.drawable.ic_action_like))


        //creating our adapter
        val adapter = BookAdapter(users)

        //now adding the adapter to recyclerview
        recyclerView.adapter = adapter

        return view
    }

}