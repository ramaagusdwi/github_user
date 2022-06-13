package com.example.githubuser.presentation.github_users

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.githubuser.R
import com.example.githubuser.models.GithubUser
import com.example.githubuser.utils.Utils
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getSupportActionBar()!!.setTitle("Github User's");

        val jsonFileString = Utils().getJsonDataFromAsset(
            applicationContext,
            "githubuser.json"
        )
        val gson = Gson()
        val githubUserType = object : TypeToken<GithubUser>() {}.type
        var githubUser: GithubUser =
            gson.fromJson(jsonFileString, githubUserType)

        // getting the recyclerview by its id
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerview)

        // this creates a vertical layout Manager
        recyclerView.layoutManager = LinearLayoutManager(this)

        // This will pass the ArrayList to our Adapter
        val adapter = GithubUserAdapter(githubUser.users, this)

        // Setting the Adapter with the recyclerview
        recyclerView.adapter = adapter
    }
}