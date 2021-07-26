package com.example.acropoilskotlinproject.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.activity.addCallback
import androidx.navigation.fragment.findNavController
import com.example.acropoilskotlinproject.R
import com.example.acropoilskotlinproject.extensions.Extensions.toast
import com.example.acropoilskotlinproject.utills.FirebaseUtils.firebaseAuth
import com.example.acropoilskotlinproject.utills.FirebaseUtils.firebaseUser
import kotlinx.android.synthetic.main.fragment_create_account.*
import kotlinx.android.synthetic.main.fragment_create_account.view.*


class CreateAccountFragment : Fragment() {

    lateinit var userEmail: String
    lateinit var userPassword: String
    lateinit var createAccountInputsArray: Array<EditText>


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val view: View =  inflater.inflate(R.layout.fragment_create_account, container, false)

        createAccountInputsArray = arrayOf(view.etEmail, view.etPassword, view.etConfirmPassword)
        view.btnCreateAccount.setOnClickListener {
            signIn()
        }

        view.btnSignIn2.setOnClickListener {
            findNavController().navigate(R.id.action_createAccountFragment_to_signInFragment)
//            startActivity(Intent(this, SignInActivity::class.java))
            toast("please sign into your account")

        }
        val callback = requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner) {
            // Handle the back button event
        }

        return view
    }

    private fun notEmpty(): Boolean = etEmail.text.toString().trim().isNotEmpty() &&
            etPassword.text.toString().trim().isNotEmpty() &&
            etConfirmPassword.text.toString().trim().isNotEmpty()

    private fun identicalPassword(): Boolean {
        var identical = false
        if (notEmpty() &&
            etPassword.text.toString().trim() == etConfirmPassword.text.toString().trim()
        ) {
            identical = true
        } else if (!notEmpty()) {
            createAccountInputsArray.forEach { input ->
                if (input.text.toString().trim().isEmpty()) {
                    input.error = "${input.hint} is required"
                }
            }
        } else {
            toast("passwords are not matching !")
        }
        return identical
    }

    private fun signIn() {
        if (identicalPassword()) {
            // identicalPassword() returns true only  when inputs are not empty and passwords are identical
            userEmail = etEmail.text.toString().trim()
            userPassword = etPassword.text.toString().trim()

            /*create a user*/
            firebaseAuth.createUserWithEmailAndPassword(userEmail, userPassword)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        toast("created account successfully !")
                        sendEmailVerification()
                        findNavController().navigate(R.id.action_createAccountFragment_to_homeFragment)

//                        startActivity(Intent(this, HomeActivity::class.java))

                    } else {
                        toast("failed to Authenticate !")
                    }
                }
        }
    }

    private fun sendEmailVerification() {
        firebaseUser?.let {
            it.sendEmailVerification().addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    toast("email sent to $userEmail")
                }
            }
        }
    }

}