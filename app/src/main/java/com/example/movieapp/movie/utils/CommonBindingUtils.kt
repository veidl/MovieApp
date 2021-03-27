package com.example.movieapp.movie.utils

import android.widget.RatingBar
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.movieapp.movie.data.Movie

object CommonBindingUtil {

    @BindingAdapter("android:text")
    @JvmStatic
    fun setText(view: TextView, text: MutableList<String>) {
        view.text = text.joinToString(", ")
    }

    @BindingAdapter("android:rating")
    @JvmStatic
    fun setRating(ratingBar: RatingBar, rating: Float) {
        if (rating in 0.0..5.0)
            ratingBar.rating = rating
    }
}