package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast // Ensure this import is included
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.myapplication.databinding.ActivityMainBinding
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var fragmentManager: FragmentManager
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        val toggle = ActionBarDrawerToggle(this, binding.DrawerLayout, binding.toolbar, R.string.open_nav, R.string.close_nav)
        binding.DrawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        binding.navView.setNavigationItemSelectedListener(this)

        binding.bottomBar.background = null
        binding.bottomnavBar.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.bottom_home -> openFragment(HomeFragment())
                R.id.bottom_search -> openFragment(SearchFragment())
                R.id.bottom_playlist -> openFragment(PlaylistFragment())
                R.id.bottom_favorites -> openFragment(FavoritesFragment())
            }
            true
        }
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, SettingFragment())
            .commit()
        fragmentManager = supportFragmentManager
        openFragment(HomeFragment())
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_new -> openFragment(NewFragment())
            R.id.nav_history -> openFragment(HistoryFragment())
            R.id.nav_profile -> openFragment(ProfileFragment())
            R.id.nav_settings -> openFragment(SettingFragment())
            R.id.nav_logout -> {
                // Handle logout
                Toast.makeText(this, "Logged out", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
                finish() // Close MainActivity
            }
        }
        binding.DrawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

    override fun onBackPressed() {
        if (binding.DrawerLayout.isDrawerOpen(GravityCompat.START)) {
            binding.DrawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    private fun openFragment(fragment: Fragment) {
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragment_container, fragment)
        fragmentTransaction.commit()
    }
}
