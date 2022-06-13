package com.example.githubuser.presentation.github_users

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.githubuser.R
import com.example.githubuser.models.User
import com.example.githubuser.presentation.detail_users.DetailGithubUsersActivity


class GithubUserAdapter(
    private val mList: List<User>, private val context: Context
) :
    RecyclerView.Adapter<GithubUserAdapter.ViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        // inflates the card_view_design view
        // that is used to hold list item
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.card_view_design, parent, false
        )
        return ViewHolder(view)
    }

    // binds the list items to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val ItemsViewModel = mList[position]

        // sets the image to the imageview from our itemHolder class
        val uri = ItemsViewModel.avatar

        val imageResource: Int =
            context.getResources().getIdentifier(
                uri, null, context
                    .getPackageName()
            )
        val res: Drawable = context.getResources().getDrawable(imageResource)
        holder.imageView.setImageDrawable(res)

        // sets the text to the textview from our itemHolder class
        holder.textView.text = ItemsViewModel.username
        holder.textView2.text = ItemsViewModel.name



        holder.constraintLayout.setOnClickListener {
            val activity = holder.itemView.context as Activity
            val intentDetail =
                Intent(activity, DetailGithubUsersActivity::class.java)
            intentDetail.putExtra(
                DetailGithubUsersActivity.EXTRA_USER,
                ItemsViewModel
            )
            activity.startActivity(intentDetail)
        }
    }

    override fun getItemCount(): Int {
        return mList.size;
    }

    // Holds the views for adding it to image and text and linearLayout
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imageView)
        val textView: TextView = itemView.findViewById(R.id.textView)
        val textView2: TextView = itemView.findViewById(R.id.textView2)
        val constraintLayout: ConstraintLayout =
            itemView.findViewById(R.id.constraintLayout1)
    }
}