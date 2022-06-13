package com.example.githubuser.presentation.detail_users

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.githubuser.R
import com.example.githubuser.models.User

class DetailGithubUsersActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_USER = "extra_user"
    }

    override fun onCreate(
        savedInstanceState: Bundle?
    ) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_users)
        getSupportActionBar()!!.setTitle("Detail User");

        val users = intent.getParcelableExtra<User>(EXTRA_USER) as User
        val text = "Name : ${users.name.toString()},\nUsername : ${
            users
                .username
        }," + "Avatar : ${users.avatar.toString()},\nCompany: ${
            users
                .company
        }," +
                "\nRepository : ${users.repository},\nFollower : ${
                    users
                        .follower
                },\n" +
                "Following : ${users.following}"
        Log.d("cekUserExtra", text)


        val imageResource: Int =
            getResources().getIdentifier(users.avatar, null, getPackageName())
        val res: Drawable = getResources().getDrawable(imageResource)
        val iv_avatar: ImageView = findViewById(R.id.iv_avatar)
        iv_avatar.setImageDrawable(res)


        val tvRepo: TextView = findViewById(R.id.tv_repositories)
        tvRepo.text = users.repository.toString()

        val tvFollowing: TextView = findViewById(R.id.tv_following)
        tvFollowing.text = users.following.toString()

        val tvFollowers: TextView = findViewById(R.id.tv_followers)
        tvFollowers.text = users.follower.toString()


    }
}