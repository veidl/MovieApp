package com.example.movieapp.movie.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.movieapp.R
import com.example.movieapp.databinding.FragmentDetailBinding
import com.example.movieapp.movie.data.Movie


class DetailFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding = DataBindingUtil.inflate<FragmentDetailBinding>(
            inflater,
            R.layout.fragment_detail,
            container,
            false
        )

        binding.movie = DetailFragmentArgs.fromBundle(requireArguments()).movie

        binding.floatingButton.setOnClickListener {
            Toast.makeText(
                activity,
                "Some Action is required",
                Toast.LENGTH_SHORT
            ).show()
        }
        return binding.root
    }



}