package com.example.acropoilskotlinproject.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.acropoilskotlinproject.R
import com.example.acropoilskotlinproject.extensions.Extensions.toast
import kotlinx.android.synthetic.main.fragment_create_account.*
import kotlinx.android.synthetic.main.fragment_create_account.view.*
import kotlinx.android.synthetic.main.fragment_feedback.view.*

class FeedbackFragment : Fragment() {
    // TODO: Rename and change types of parameters

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View =  inflater.inflate(R.layout.fragment_feedback, container, false)

        view.btnSubmit.setOnClickListener {

            if (view.etfeedbak.text.toString().trim().isNotEmpty()){
                view.etfeedbak.setText("")
                toast("FeedBack Submit Successfully")
            } else{
                toast("Please Enter The Value")
            }





        }

        return view
    }


}