package com.bignerdranch.express

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.widget.TextView
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.navigation.NavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import com.bignerdranch.express.databinding.ActivityNavBinding

class NavActivity : AppCompatActivity() {
    private val TAG = "NavActivity"

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityNavBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityNavBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.appBarNav.toolbar)

//        binding.appBarNav.fab.setOnClickListener { view ->
//            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                .setAction("Action", null)
//                .setAnchorView(R.id.fab).show()
//        }
        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_content_nav)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_mainline, R.id.nav_profile
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        val username = intent.extras?.getString("username")
        Log.d(TAG, "username passed in onViewCreated as $username")

        // Find NavigationView
        Log.d(TAG, "finding nav view")
        val navigationView = findViewById<NavigationView>(R.id.nav_view)
        // Find TextView inside the header
        val navHeaderView = navigationView.getHeaderView(0)
        Log.d(TAG, "finding nav header title textview")
        val welcomeUserTextView = navHeaderView.findViewById<TextView>(R.id.nav_header_title_textView)
        // Set text to the TextView
        Log.d(TAG, "displaying welcome message in sidebar")
        welcomeUserTextView?.text = "Welcome, $username."

    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_nav)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}