package com.example.movieapp.movie.fragments

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.movieapp.R
import com.example.movieapp.databinding.FragmentHomeBinding
import com.example.movieapp.movie.data.Movie
import com.example.movieapp.movie.home.HomeAdapter

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding = DataBindingUtil.inflate<FragmentHomeBinding>(
            inflater,
            R.layout.fragment_home,
            container,
            false
        )

        val adapter = HomeAdapter()

        binding.movieList.adapter = adapter

        adapter.data = listOf(
            initMovie().copy(title = "jebaited"),
            initMovie().copy(description = "Something else"),
            initMovie().copy(title = "Test"),
            initMovie(),
            initMovie(),
            initMovie(),
            initMovie(),
            initMovie(),
            initMovie(),
            initMovie(),
            initMovie(),
            initMovie(),
            initMovie(),
            initMovie(),
            initMovie(),
            initMovie(),
            initMovie(),
            initMovie()
        )

        setHasOptionsMenu(true)

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.navdrawer_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(
            item,
            requireView().findNavController()
        ) || super.onOptionsItemSelected(item)
    }

    private fun initMovie(): Movie {
        val movie = Movie(
            title = "The Dark Knight",
            description = "wow such a cool moviewow such a cool moviewow such a cool moviewow such a cool moviewow such a cool moviewow such a cool moviewow such a cool moviewow such a cool moviewow such a cool moviewow such a cool moviewow such a cool moviewow such a cool moviewow such a cool moviewow such a cool moviewow such a cool moviewow such wow such a cool moviewow such a cool moviewow such a cool moviewow such a cool moviewow such a cool moviewow such a cool moviewow such a cool moviewow such a cool moviewow such a cool moviewow such a cool moviewow such a cool moviewow such a cool moviewow such a cool moviewow such a cool moviewow such a cool moviewow such a cool moviewow such a cool moviewow such a cool moviewow such a cool moviewow such a cool moviewow such a cool moviewow such a cool moviewow such a cool moviewow such a cool moviewow such a cool moviewow such a cool moviewow such a cool moviewow such a cool moviewow such a cool moviewow such a cool moviewow such a cool moviewow such a cool moviewow such a cool moviewow such a cool moviewow such a cool moviewow such a cool moviewow such a cool moviewow such a cool moviewow such a cool moviewow such a cool moviewow such a cool moviewow such a cool moviewow such a cool moviewow such a cool moviewow such a cool moviewow such a cool moviewow such a cool moviewow such a cool moviewow such a cool moviewow such a cool moviewow such a cool moviewow such a cool moviewow such a cool moviewow such a cool moviea cool moviewow such a cool moviewow such a cool moviewow such a cool moviewow such a cool moviewow such a cool movie",

            genres = mutableListOf("Action", "Drama"),
            creators = mutableListOf("Christian Bale", "John Wick"),
            authors = mutableListOf("woher? weist ich das"),
            actors = mutableListOf("Anya Taylor, Chloe someone")
        )
        movie.rating = 3.0F
        return movie
    }
}