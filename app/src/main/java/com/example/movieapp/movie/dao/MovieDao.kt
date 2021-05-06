package com.example.movieapp.movie.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.movieapp.movie.data.Movie

@Dao
interface MovieDao {
    @Insert
    fun create(movie: Movie)

    @Update
    fun update(movie: Movie)

    @Query("delete from movies where id = :movieId")
    fun delete(movieId: Long)

    @Query("delete from movies")
    fun clearTable()

    @Query("select * from movies")
    fun getAll(): LiveData<List<Movie>>
}