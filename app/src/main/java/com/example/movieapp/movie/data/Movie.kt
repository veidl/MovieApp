package com.example.movieapp.movie.data

import androidx.annotation.DrawableRes
import com.example.movieapp.R
import java.io.Serializable

data class Movie(
    val title: String,
    val description: String,
    val genres: MutableList<String>? = mutableListOf("No Genres available"),
    val creators: MutableList<String>,
    val authors: MutableList<String>,
    val actors: MutableList<String>,
    @DrawableRes val img: Int? = R.drawable.fimklappe
) : Serializable {

    var rating: Float = 0.0F
        set(value) {
            if (value in 0.0..5.0) field = value
            else throw IllegalArgumentException("Rating must be between 0 and 5 Stars")
        }
}
