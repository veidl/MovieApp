package com.example.movieapp.movie

data class Movie(
    val title: String,
    val description: String,
    val rating: Float,
    val genres: String? = "No Genres available",
    val creators: String,
    val authors: String,
    val actors: String
)
