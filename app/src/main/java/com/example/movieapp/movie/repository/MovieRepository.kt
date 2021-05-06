package com.example.movieapp.movie.repository

import androidx.lifecycle.LiveData
import com.example.movieapp.movie.dao.MovieDao
import com.example.movieapp.movie.data.Movie
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MovieRepository(private val movieDao: MovieDao) {

    fun getMovies(): LiveData<List<Movie>> {
        return movieDao.getAll()
    }

    suspend fun insert(movie: Movie) {
        withContext(Dispatchers.IO) {
            return@withContext movieDao.create(movie)
        }
    }

    suspend fun update(movie: Movie) {
        withContext(Dispatchers.IO) {
            movieDao.update(movie)
        }
    }

    suspend fun delete(movieId: Long) {
        withContext(Dispatchers.IO) {
            movieDao.delete(movieId)
        }
    }

    suspend fun deleteAll() {
        withContext(Dispatchers.IO) {
            movieDao.clearTable()
        }
    }

    companion object {
        // For Singleton instantiation
        @Volatile
        private var instance: MovieRepository? = null

        fun getInstance(dao: MovieDao) =
            instance ?: synchronized(this) {
                instance ?: MovieRepository(dao).also { instance = it }
            }
    }
}