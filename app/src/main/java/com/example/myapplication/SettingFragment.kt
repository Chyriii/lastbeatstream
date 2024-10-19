package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment

class SettingFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_setting, container, false)

        // Handle button clicks
        view.findViewById<TextView>(R.id.account_button).setOnClickListener {
            Toast.makeText(context, "Account clicked", Toast.LENGTH_SHORT).show()
        }

        view.findViewById<TextView>(R.id.privacy_social_button).setOnClickListener {
            Toast.makeText(context, "Privacy and Social clicked", Toast.LENGTH_SHORT).show()
        }

        view.findViewById<TextView>(R.id.notifications_button).setOnClickListener {
            Toast.makeText(context, "Notifications clicked", Toast.LENGTH_SHORT).show()
        }

        view.findViewById<TextView>(R.id.about_button).setOnClickListener {
            Toast.makeText(context, "About clicked", Toast.LENGTH_SHORT).show()
        }

        // Handle logout button click
        view.findViewById<Button>(R.id.logout_button).setOnClickListener {
            Toast.makeText(context, "Logged out", Toast.LENGTH_SHORT).show()

            // Start LoginActivity and finish MainActivity to prevent going back
            val intent = Intent(activity, LoginActivity::class.java)
            startActivity(intent)
            activity?.finish() // Close MainActivity
        }

        return view
    }
}