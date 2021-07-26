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
import kotlinx.android.synthetic.main.fragment_sign_in.*
import kotlinx.android.synthetic.main.fragment_sign_in.view.*


class SignInFragment : Fragment() {

    lateinit var signInEmail: String
    lateinit var signInPassword: String
    lateinit var signInInputsArray: Array<EditText>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_sign_in, container, false)

        signInInputsArray = arrayOf(view.etSignInEmail, view.etSignInPassword)

        view.text_sign_in.setOnClickListener {
            findNavController().navigate(R.id.action_signInFragment_to_createAccountFragment)
//            startActivity(Intent(this, CreateAccountActivity::class.java))

        }

        view.btnSignIn.setOnClickListener {
            signInUser()
        }

        val callback = requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner) {
            // Handle the back button event
        }
        return view;

    }

    private fun notEmpty(): Boolean = signInEmail.isNotEmpty() && signInPassword.isNotEmpty()

    private fun signInUser() {
        signInEmail = etSignInEmail.text.toString().trim()
        signInPassword = etSignInPassword.text.toString().trim()

        if (notEmpty()) {
            firebaseAuth.signInWithEmailAndPassword(signInEmail, signInPassword)
                .addOnCompleteListener { signIn ->
                    if (signIn.isSuccessful) {
                        findNavController().navigate(R.id.action_signInFragment_to_homeFragment)
//                        startActivity(Intent(this, HomeActivity::class.java))
                        toast("signed in successfully")

                    } else {
                        toast("sign in failed")
                    }
                }
        } else {
            signInInputsArray.forEach { input ->
                if (input.text.toString().trim().isEmpty()) {
                    input.error = "${input.hint} is required"
                }
            }
        }
    }

}