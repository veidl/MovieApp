package com.example.movieapp.movie.home

import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.movieapp.R

class HomeItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val movieTitle: TextView = itemView.findViewById(R.id.txt_home_title)
    val actor: TextView = itemView.findViewById(R.id.txt_home_actors)
    val creator: TextView = itemView.findViewById(R.id.txt_home_creators)
    val seeDetail: Button = itemView.findViewById(R.id.btn_home_details)
}