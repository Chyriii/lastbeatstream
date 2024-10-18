package com.example.myapplication

import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CompoundButton
import android.widget.Switch
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment


class SettingFragment : Fragment() {

    private lateinit var darkModeSwitch: Switch
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_setting, container, false)

        // Set the initial state of the switch
        darkModeSwitch.isChecked = sharedPreferences.getBoolean("DARK_MODE", false)

        // Handle switch changes
        darkModeSwitch.setOnCheckedChangeListener { _: CompoundButton, isChecked: Boolean ->
            sharedPreferences.edit().putBoolean("DARK_MODE", isChecked).apply()
            if (isChecked) {
                // Set dark mode
                requireActivity().setTheme(R.style.Theme_MyApplication) // Adjust theme for dark mode
            } else {
                // Set light mode
                requireActivity().setTheme(R.style.Theme_MyApplication) // Adjust theme for light mode
            }
            requireActivity().recreate() // Recreate activity to apply changes
        }

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

        view.findViewById<Button>(R.id.logout_button).setOnClickListener {
            Toast.makeText(context, "Logged out", Toast.LENGTH_SHORT).show()
        }

        return view
    }
}
