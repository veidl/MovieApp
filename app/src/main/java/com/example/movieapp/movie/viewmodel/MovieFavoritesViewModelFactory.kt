package com.example.movieapp.movie.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.movieapp.movie.repository.MovieRepository
import java.lang.IllegalArgumentException

@Suppress("UNCHECKED_CAST")
class MovieFavoritesViewModelFactory(private val repository: MovieRepository) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MovieFavoritesViewModel::class.java)) {
            return MovieFavoritesViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown Viewmodel")
    }
}