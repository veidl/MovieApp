package com.example.movieapp.movie.data

import androidx.annotation.DrawableRes
import androidx.room.*
import com.example.movieapp.R
import java.io.Serializable

@Entity(tableName = "movies")
data class Movie(
    // should be unique - to much effort. lel
    val title: String,
    val description: String,
    val genres: MutableList<String>? = mutableListOf("No Genres available"),
    val creators: MutableList<String>,
    val authors: MutableList<String>,
    val actors: MutableList<String>,
    @DrawableRes val img: Int? = R.drawable.fimklappe,
    var note: String? = ""
) : Serializable {

    var rating: Float = 0.0F
        set(value) {
            if (value in 0.0..5.0) field = value
            else throw IllegalArgumentException("Rating must be between 0 and 5 Stars")
        }

    @PrimaryKey(autoGenerate = true)
    var id: Long? = null
}
