package com.example.movieapp.movie.viewmodel

import androidx.lifecycle.ViewModel
import com.example.movieapp.movie.data.Movie
import com.example.movieapp.movie.repository.MovieRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class MovieFavoritesViewModel(private val repository: MovieRepository) :
    ViewModel() {

    private var viewModelJob = Job()

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }

    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)
    val favoriteMovies = repository.getMovies()


    fun addMovie(movie: Movie) = uiScope.launch { repository.insert(movie) }

    fun deleteMovie(movieId: Long) = uiScope.launch { repository.delete(movieId) }

    fun deleteAllFavorites() = uiScope.launch { repository.deleteAll() }

    fun updateMovie(movie: Movie) = uiScope.launch { repository.update(movie) }


}