package com.example.projeto_streetartcei

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.projeto_streetartcei.R
import com.google.firebase.auth.FirebaseAuth

class ProfileFragment : Fragment() {

    private lateinit var auth: FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val rootView = inflater.inflate(R.layout.fragment_profile, container, false)

        // Initialize Firebase Auth
        auth = FirebaseAuth.getInstance()

        // Find views
        val textViewLogout: TextView = rootView.findViewById(R.id.textViewLogout)

        // Set logout button click listener
        textViewLogout.setOnClickListener {
            // Perform logout action here
            // You can add your logout logic here
            auth.signOut()
            redirectToLogin()
        }

        // Check if user is logged in
        if (auth.currentUser == null) {
            // If user is not logged in, redirect to login
            redirectToLogin()
        }

        return rootView
    }

    private fun redirectToLogin() {
        val intent = Intent(requireContext(), SignInActivity::class.java)
        startActivity(intent)
        requireActivity().finish() // Finish the profile activity to prevent user from accessing it without login
    }
}
