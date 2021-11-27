package com.example.destinyworld

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.bumptech.glide.Glide
import com.example.destinyworld.databinding.ActivityMenuBinding
import com.example.destinyworld.databinding.FragmentHomeBinding
import com.example.destinyworld.ui.home.HomeFragment

class MenuActivity : AppCompatActivity() {
    lateinit var  sharedPreferences: SharedPreferences
    private var _binding: FragmentHomeBinding? = null
    lateinit var email_text:TextView
    lateinit var name_text:TextView
    lateinit var ImageView: ImageView
    private lateinit var binding: ActivityMenuBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)
        sharedPreferences = getSharedPreferences("main", Context.MODE_PRIVATE)!!
        val email = sharedPreferences.getString("email", null)
        val avatar = sharedPreferences.getString("avatar",null)
        val name = sharedPreferences.getString("name",null)
        email_text = findViewById(R.id.email_text)
        ImageView = findViewById(R.id.avatar_img)
        name_text = findViewById(R.id.name_text)
        email_text.text = email
        name_text.text = name

        Glide.with(applicationContext).load(avatar).circleCrop().into(ImageView)

        val navView: BottomNavigationView = binding.navView
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment_activity_menu) as NavHostFragment
        val navController = navHostFragment.navController
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        navView.setupWithNavController(navController)


    }
}