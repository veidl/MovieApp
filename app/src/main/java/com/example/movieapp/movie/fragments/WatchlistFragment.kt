package com.example.movieapp.movie.fragments

import android.app.AlertDialog
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.LinearLayout
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.movieapp.R
import com.example.movieapp.databinding.FragmentWatchlistBinding
import com.example.movieapp.movie.data.Movie
import com.example.movieapp.movie.database.AppDatabase
import com.example.movieapp.movie.favoriteMovies.FavoritesListAdapter
import com.example.movieapp.movie.repository.MovieRepository
import com.example.movieapp.movie.viewmodel.MovieFavoritesViewModel
import com.example.movieapp.movie.viewmodel.MovieFavoritesViewModelFactory


class WatchlistFragment : Fragment() {

    private lateinit var binding: FragmentWatchlistBinding
    private lateinit var viewModel: MovieFavoritesViewModel
    private lateinit var viewModelFactory: MovieFavoritesViewModelFactory

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_watchlist, container, false)

        val adapter = FavoritesListAdapter(
            dataSet = listOf(),
            onDeleteClicked = { onDelete(it) },
            onEditClicked = { onEdit(it) }
        )

        with(binding) {
            recyclerView.adapter = adapter
        }

        initConnections()

        viewModel.favoriteMovies.observe(viewLifecycleOwner, { adapter.updateDataSet(it) })

        binding.clearBtn.setOnClickListener {
            viewModel.deleteAllFavorites()
        }

        return binding.root
    }

    private fun onEdit(movie: Movie) {
        activity?.let { context ->
            val input = EditText(context)
            movie.note?.let { text -> input.setText(text) }
            input.setSelection(input.text.toString().length)

            val layout = LinearLayout(context)
                .also { it.orientation = LinearLayout.VERTICAL }
                .also { it.gravity = Gravity.CENTER_HORIZONTAL }
                .also { it.setPadding(50, 0, 50, 0)}

            val builder = AlertDialog.Builder(context)
            builder.setMessage("Take a note")
                .setPositiveButton(
                    "Save"
                ) { _, _ ->
                    movie.note = input.text.toString()
                    viewModel.updateMovie(movie)
                }
                .setNegativeButton(
                    "Cancel"
                ) { dialog, _ ->
                    dialog.cancel()
                }

            layout.addView(input)
            builder.setView(layout)
            builder.create()
            builder.show()
        } ?: throw IllegalStateException("Activity cannot be null")
    }

    private fun onDelete(id: Long) {
        viewModel.deleteMovie(id)
    }

    private fun initConnections() {
        val data = this.activity?.let { AppDatabase.getInstance(it.application).movieDatabaseDao }
            ?: throw NullPointerException("cannot get instance of movieDao")

        viewModelFactory = MovieFavoritesViewModelFactory(MovieRepository.getInstance(data))

        viewModel =
            ViewModelProvider(this, viewModelFactory).get(MovieFavoritesViewModel::class.java)
    }

}