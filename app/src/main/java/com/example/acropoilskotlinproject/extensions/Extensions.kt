package com.example.acropoilskotlinproject.extensions

import android.widget.Toast
import androidx.fragment.app.Fragment

object Extensions {
    fun Fragment.toast(msg: String){
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
    }
}