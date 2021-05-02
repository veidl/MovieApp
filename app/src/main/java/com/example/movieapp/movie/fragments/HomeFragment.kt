package com.example.movieapp.movie.fragments

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.movieapp.R
import com.example.movieapp.databinding.FragmentHomeBinding
import com.example.movieapp.movie.data.Movie
import com.example.movieapp.movie.home.HomeAdapter

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

        val adapter = HomeAdapter()

        binding.movieList.adapter = adapter

        adapter.data = listOf(
            initQueensGambit(),
            initTheDarkKnight(),
            initQueensGambit(),
            initQueensGambit(),
            initQueensGambit(),
            initQueensGambit()
        )

        setHasOptionsMenu(true)

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.navdrawer_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(
            item,
            requireView().findNavController()
        ) || super.onOptionsItemSelected(item)
    }

    private fun initQueensGambit(): Movie {
        val movie = Movie(
            title = "The Queen's Gambit",
            genres = mutableListOf("Drama", "Sport"),
            actors = mutableListOf("Sahil", "Thomas", "Baljinder"),
            creators = mutableListOf("Oliver", "Jennifer"),
            description = "The Queen's Gambit follows the life of an orphan chess prodigy, Elizabeth Harmon, during her quest to become the world's " +
                    "greatest chess player while struggling with emotional problems and drug and alcohol dependency. The title of the series refers to a " +
                    "chess opening of the same name. The story begins in the mid-1950s and proceeds into the 1960s. The story begins in Lexington, Kentucky, where a " +
                    "nine-year-old Beth, having lost her mother in a car crash, is taken to an orphanage where she is taught chess by the building's custodian, Mr. Shaibel. " +
                    "As was common during the 1950s, the orphanage dispenses daily tranquilizer pills to the girls,[5][6] which turns into an addiction for Beth. She quickly " +
                    "becomes a strong chess player due to her visualization skills, which are enhanced by the tranquilizers. A few years later, Beth is adopted by Alma Wheatley " +
                    "and her husband from Lexington. As she adjusts to her new home, Beth enters a chess tournament and wins despite having no prior experience in competitive chess. " +
                    "She develops friendships with several people, including former Kentucky State Champion Harry Beltik, United States National Champion Benny Watts, and journalist " +
                    "and fellow player D.L. Townes. As Beth rises to the top of the chess world and reaps the financial benefits of her success, her drug and alcohol dependency becomes worse.",
            img = R.drawable.the_queen_s_gambit,
            authors = mutableListOf("SomeOne")
        )
        movie.rating = 4.0F
        return movie
    }

    private fun initTheDarkKnight(): Movie {
        val movie = Movie(
            title = "The Dark Knight",
            genres = mutableListOf("Drama", "Sport"),
            actors = mutableListOf("Sahil", "Thomas", "Baljinder"),
            creators = mutableListOf("Oliver", "Jennifer"),
            description = "The Queen's Gambit follows the life of an orphan chess prodigy, Elizabeth Harmon, during her quest to become the world's " +
                    "greatest chess player while struggling with emotional problems and drug and alcohol dependency. The title of the series refers to a " +
                    "chess opening of the same name. The story begins in the mid-1950s and proceeds into the 1960s. The story begins in Lexington, Kentucky, where a " +
                    "nine-year-old Beth, having lost her mother in a car crash, is taken to an orphanage where she is taught chess by the building's custodian, Mr. Shaibel. " +
                    "As was common during the 1950s, the orphanage dispenses daily tranquilizer pills to the girls,[5][6] which turns into an addiction for Beth. She quickly " +
                    "becomes a strong chess player due to her visualization skills, which are enhanced by the tranquilizers. A few years later, Beth is adopted by Alma Wheatley " +
                    "and her husband from Lexington. As she adjusts to her new home, Beth enters a chess tournament and wins despite having no prior experience in competitive chess. " +
                    "She develops friendships with several people, including former Kentucky State Champion Harry Beltik, United States National Champion Benny Watts, and journalist " +
                    "and fellow player D.L. Townes. As Beth rises to the top of the chess world and reaps the financial benefits of her success, her drug and alcohol dependency becomes worse.",
            img = R.drawable.the_dark_knight,
            authors = mutableListOf("SomeOne"),
        )
        movie.rating = 3F
        return movie
    }
}