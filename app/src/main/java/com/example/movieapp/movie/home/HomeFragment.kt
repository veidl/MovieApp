package com.example.movieapp.movie.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.movieapp.R
import com.example.movieapp.databinding.FragmentHomeBinding
import com.example.movieapp.movie.data.Movie

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding = DataBindingUtil.inflate<FragmentHomeBinding>(
            inflater,
            R.layout.fragment_home,
            container,
            false
        )

        binding.movie = initMovie()

        setHasOptionsMenu(true)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        insertNestedFragments()
    }

    private fun insertNestedFragments() {
        val bundle = Bundle()
        bundle.putSerializable("movie", initMovie())

        val homeItemsFragment = HomeItemsFragment()
        homeItemsFragment.arguments = bundle

        childFragmentManager.beginTransaction().replace(R.id.homeItemFragment, homeItemsFragment)
            .commit()
    }

    private fun initMovie(): Movie {
        return Movie(
            title = "The Dark Knight",
            description = "wow such a cool moviewow such a cool moviewow such a cool moviewow such a cool moviewow such a cool moviewow such a cool moviewow such a cool moviewow such a cool moviewow such a cool moviewow such a cool moviewow such a cool moviewow such a cool moviewow such a cool moviewow such a cool moviewow such a cool moviewow such wow such a cool moviewow such a cool moviewow such a cool moviewow such a cool moviewow such a cool moviewow such a cool moviewow such a cool moviewow such a cool moviewow such a cool moviewow such a cool moviewow such a cool moviewow such a cool moviewow such a cool moviewow such a cool moviewow such a cool moviewow such a cool moviewow such a cool moviewow such a cool moviewow such a cool moviewow such a cool moviewow such a cool moviewow such a cool moviewow such a cool moviewow such a cool moviewow such a cool moviewow such a cool moviewow such a cool moviewow such a cool moviewow such a cool moviewow such a cool moviewow such a cool moviewow such a cool moviewow such a cool moviewow such a cool moviewow such a cool moviewow such a cool moviewow such a cool moviewow such a cool moviewow such a cool moviewow such a cool moviewow such a cool moviewow such a cool moviewow such a cool moviewow such a cool moviewow such a cool moviewow such a cool moviewow such a cool moviewow such a cool moviewow such a cool moviewow such a cool moviewow such a cool moviewow such a cool moviewow such a cool moviewow such a cool moviea cool moviewow such a cool moviewow such a cool moviewow such a cool moviewow such a cool moviewow such a cool movie",
            rating = 1F,
            genres = mutableListOf("Action", "Drama"),
            creators = mutableListOf("Christian Bale", "John Wick"),
            authors = mutableListOf("woher? weist ich das"),
            actors = mutableListOf("Anya Taylor, Chloe someone")
        )
    }
}