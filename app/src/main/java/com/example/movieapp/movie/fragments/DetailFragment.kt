package com.example.movieapp.movie.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.movieapp.R
import com.example.movieapp.databinding.FragmentDetailBinding
import com.example.movieapp.movie.data.Movie
import com.example.movieapp.movie.database.AppDatabase
import com.example.movieapp.movie.repository.MovieRepository
import com.example.movieapp.movie.viewmodel.MovieFavoritesViewModel
import com.example.movieapp.movie.viewmodel.MovieFavoritesViewModelFactory


class DetailFragment : Fragment() {

    private lateinit var viewModel: MovieFavoritesViewModel
    private lateinit var viewModelFactory: MovieFavoritesViewModelFactory

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding = DataBindingUtil.inflate<FragmentDetailBinding>(
            inflater,
            R.layout.fragment_detail,
            container,
            false
        )

        this.initConnections()

        val movie = DetailFragmentArgs.fromBundle(requireArguments()).movie
        binding.movie = movie

        binding.floatingButton.setOnClickListener {
            viewModel.addMovie(
                movie
            ).also {
                Toast.makeText(
                    activity,
                    "Movie ${movie.title} added to the watchlist!",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
        return binding.root
    }


    private fun initConnections() {
        val data = this.activity?.let { AppDatabase.getInstance(it.application).movieDatabaseDao }
            ?: throw NullPointerException("cannot get instance of movieDao")

        viewModelFactory = MovieFavoritesViewModelFactory(MovieRepository.getInstance(data))

        viewModel =
            ViewModelProvider(this, viewModelFactory).get(MovieFavoritesViewModel::class.java)
    }

}