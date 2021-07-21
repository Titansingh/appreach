package com.example.socialapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.socialapp.models.Post
import com.firebase.ui.firestore.FirestoreRecyclerOptions
import com.google.android.material.navigation.NavigationView
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.Query
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val drawerLayout: DrawerLayout = findViewById(R.id.drawerlayout)
        val navView: NavigationView = findViewById(R.id.nav_view)

        showName()
        showDP()


        toggle = ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        navView.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.nav_home -> Toast.makeText(
                    applicationContext,
                    "click home ",
                    Toast.LENGTH_SHORT
                ).show()
                R.id.nav_setting -> Toast.makeText(
                    applicationContext,
                    "click setting ",
                    Toast.LENGTH_SHORT
                ).show()
                R.id.nav_logout -> Toast.makeText(applicationContext, "logout ", Toast.LENGTH_SHORT)
                    .show()
                R.id.nav_rate_us -> Toast.makeText(
                    applicationContext,
                    "rateus ",
                    Toast.LENGTH_SHORT
                ).show()
                R.id.share -> Toast.makeText(applicationContext, "click share ", Toast.LENGTH_SHORT)
                    .show()
            }
            true


        }


    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)) {

            return true
        }

        return super.onOptionsItemSelected(item)
    }

    private fun showName(){
        val txtView: TextView = findViewById(R.id.text1)
        val namer = intent.getStringExtra("name")
        txtView.text = namer
    }

    private   fun showDP(){

        val urlr = intent.getStringExtra("url")
        Glide.with(this).load(urlr).into(testimgview)

    }


}