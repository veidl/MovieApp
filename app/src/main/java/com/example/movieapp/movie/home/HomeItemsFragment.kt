package com.example.movieapp.movie.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.movieapp.R
import com.example.movieapp.databinding.FragmentHomeItemsBinding
import com.example.movieapp.movie.data.Movie


/**
 * A simple [Fragment] subclass.
 * Use the [HomeItemsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeItemsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val inflate = DataBindingUtil.inflate<FragmentHomeItemsBinding>(
            inflater,
            R.layout.fragment_home_items,
            container,
            false
        )

        inflate.movie = arguments?.get("movie") as Movie

        inflate.btnHomeDetails.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_home_to_detail)
        }

        return inflate.root
    }

}