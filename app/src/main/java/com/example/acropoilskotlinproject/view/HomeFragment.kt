package com.example.acropoilskotlinproject.view

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.activity.addCallback
import androidx.appcompat.app.AlertDialog
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.acropoilskotlinproject.R
import com.example.acropoilskotlinproject.extensions.Extensions.toast
import com.example.acropoilskotlinproject.utills.FirebaseUtils.firebaseAuth
import com.example.acropoilskotlinproject.view.adapter.CustomAdapter
import com.example.acropoilskotlinproject.view.model.Category
import com.google.firebase.auth.FirebaseUser
import kotlinx.android.synthetic.main.fragment_create_account.view.*
import kotlinx.android.synthetic.main.fragment_home.view.*


class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View =  inflater.inflate(R.layout.fragment_home, container, false)

        val user = firebaseAuth.currentUser
        if (user != null) {
            // User is signed in
            toast("welcome back")
        } else {
            findNavController().navigate(R.id.action_homeFragment_to_createAccountFragment)
            // No user is signed in
        }

        val callback = requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner) {
            context?.let { alertDialog(it) }
        }

        val recyclerView = view.findViewById(R.id.homerecyclerView) as RecyclerView

        //adding a layoutmanager
        recyclerView.layoutManager = LinearLayoutManager(context)


        //crating an arraylist to store users using the data class user
        val users = ArrayList<Category>()

        //adding some dummy data to the list
        users.add(Category("Entertainment"))
        users.add(Category("Books"))
        users.add(Category("Apps"))


        //creating our adapter
        val adapter = CustomAdapter(users)

        //now adding the adapter to recyclerview
        recyclerView.adapter = adapter

        view.feedback.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_feedbackFragment)
//            startActivity(Intent(this, SignInActivity::class.java))

        }

        return view

    }

    private fun alertDialog(context: Context) {
        val builder = AlertDialog.Builder(context)
        //set title for alert dialog
        builder.setTitle(R.string.dialogTitle)
        //set message for alert dialog
        builder.setMessage(R.string.dialogMessage)
        builder.setIcon(android.R.drawable.ic_dialog_alert)

        //performing positive action
        builder.setPositiveButton("Yes"){dialogInterface, which ->
            firebaseAuth.signOut()
            findNavController().navigate(R.id.action_homeFragment_to_signInFragment)
//            startActivity(Intent(this, CreateAccountActivity::class.java))
            toast("signed out")
        }

        //performing negative action
        builder.setNegativeButton("No"){dialogInterface, which ->

        }
        // Create the AlertDialog
        val alertDialog: AlertDialog = builder.create()
        // Set other dialog properties
        alertDialog.setCancelable(false)
        alertDialog.show()
    }


}