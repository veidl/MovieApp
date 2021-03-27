package com.example.movieapp.movie.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.movieapp.R
import com.example.movieapp.movie.data.Movie

class HomeAdapter : RecyclerView.Adapter<HomeItemViewHolder>() {
    var data = listOf<Movie>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeItemViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val inflate = layoutInflater.inflate(R.layout.fragment_home_items, parent, false)

        return HomeItemViewHolder(inflate)

    }

    override fun onBindViewHolder(holder: HomeItemViewHolder, position: Int) {
        val item = data[position]

        holder.movieTitle.text = item.title
        holder.actor.text = item.actors.toString()
        holder.creator.text = item.creators.toString()

        val bundle = bundleOf("movie" to item)

        holder.seeDetail.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_home_to_detail, bundle)
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }

}