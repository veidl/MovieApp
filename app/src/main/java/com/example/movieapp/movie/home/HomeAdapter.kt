package com.example.movieapp.movie.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.movieapp.R
import com.example.movieapp.movie.data.Movie
import com.example.movieapp.movie.fragments.HomeFragmentDirections
import com.example.movieapp.movie.utils.CommonBindingUtil

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
        CommonBindingUtil.setText(holder.actor, item.actors)
        CommonBindingUtil.setText(holder.creator, item.creators)

        holder.seeDetail.setOnClickListener { view: View ->
            view.findNavController().navigate(HomeFragmentDirections.actionHomeToDetail(item))
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }
}