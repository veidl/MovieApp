package com.example.movieapp.movie.data

data class Movie(
    val title: String,
    val description: String,
    val rating: Float,
    val genres: MutableList<String>? = mutableListOf("No Genres available"),
    val creators: MutableList<String>,
    val authors: MutableList<String>,
    val actors: MutableList<String>
) {

}
