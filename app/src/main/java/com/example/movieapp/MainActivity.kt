package com.example.movieapp

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.movieapp.databinding.ActivityMainBinding
import com.example.movieapp.movie.Movie
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val contentView =
            DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        contentView.movie = initMovie()

        findViewById<FloatingActionButton>(R.id.floatingButton).setOnClickListener {
            Toast.makeText(this, "Some Action is required", Toast.LENGTH_SHORT).show()
        }


    }

    private fun initMovie(): Movie {
        return Movie(
            title = "The Dark Knight",
            description = "wow such a cool moviewow such a cool moviewow such a cool moviewow such a cool moviewow such a cool moviewow such a cool moviewow such a cool moviewow such a cool moviewow such a cool moviewow such a cool moviewow such a cool moviewow such a cool moviewow such a cool moviewow such a cool moviewow such a cool moviewow such wow such a cool moviewow such a cool moviewow such a cool moviewow such a cool moviewow such a cool moviewow such a cool moviewow such a cool moviewow such a cool moviewow such a cool moviewow such a cool moviewow such a cool moviewow such a cool moviewow such a cool moviewow such a cool moviewow such a cool moviewow such a cool moviewow such a cool moviewow such a cool moviewow such a cool moviewow such a cool moviewow such a cool moviewow such a cool moviewow such a cool moviewow such a cool moviewow such a cool moviewow such a cool moviewow such a cool moviewow such a cool moviewow such a cool moviewow such a cool moviewow such a cool moviewow such a cool moviewow such a cool moviewow such a cool moviewow such a cool moviewow such a cool moviewow such a cool moviewow such a cool moviewow such a cool moviewow such a cool moviewow such a cool moviewow such a cool moviewow such a cool moviewow such a cool moviewow such a cool moviewow such a cool moviewow such a cool moviewow such a cool moviewow such a cool moviewow such a cool moviewow such a cool moviewow such a cool moviewow such a cool moviewow such a cool moviea cool moviewow such a cool moviewow such a cool moviewow such a cool moviewow such a cool moviewow such a cool movie",
            rating = 2.5F,
            genres = "Action, Drama",
            creators = "Jonny Depp, John Wick",
            authors = "woher? weist ich das",
            actors = "Anya Taylor, Chloe someone"
        )
    }
}