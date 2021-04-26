package com.example.movieapp.movie.utils

import android.text.format.DateUtils
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.annotation.DrawableRes
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.movieapp.R
import com.example.movieapp.movie.data.Movie

object CommonBindingUtil {

    @BindingAdapter("android:text")
    @JvmStatic
    fun setText(view: TextView, text: MutableList<String>) {
        view.text = text.joinToString(", ")
    }

//    @BindingAdapter("android:rating")
//    @JvmStatic
//    fun setRating(ratingBar: RatingBar, rating: Float) {
//        if (rating in 0.0..5.0)
//            ratingBar.rating = rating
//    }

    @BindingAdapter("android:text")
    @JvmStatic
    fun setTimer(view: TextView, value: Long) {
        val timeInMS = value / 1000
        view.text = DateUtils.formatElapsedTime(timeInMS)
        if(timeInMS < 10L)
            view.setTextColor(ContextCompat.getColor(view.context, R.color.red))
        else
            view.setTextColor(ContextCompat.getColor(view.context, R.color.white))
    }

    @BindingAdapter("src")
    @JvmStatic
    fun setImageDrawable(view: ImageView, @DrawableRes drawableId: Int) {
        view.setImageResource(drawableId)
    }
}