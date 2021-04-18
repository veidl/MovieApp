package com.example.movieapp.quiz.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.movieapp.R
import com.example.movieapp.databinding.FragmentQuizEndBinding
import com.example.movieapp.quiz.viewmodel.QuizEndViewModel
import com.example.movieapp.quiz.viewmodel.QuizEndViewModelFactory


class QuizEndFragment : Fragment() {
    private lateinit var binding: FragmentQuizEndBinding
    private lateinit var viewModel: QuizEndViewModel
    private lateinit var viewModelFactory: QuizEndViewModelFactory

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_quiz_end, container, false)

        viewModelFactory = QuizEndViewModelFactory(
            QuizEndFragmentArgs.fromBundle(requireArguments()).score,
            QuizEndFragmentArgs.fromBundle(requireArguments()).maxScore
        )
        viewModel = ViewModelProvider(this, viewModelFactory).get(QuizEndViewModel::class.java)

        binding.quizEndViewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        restartQuiz()
        return binding.root
    }

    private fun restartQuiz() {
        binding.btnQuizRestart.setOnClickListener {
            view?.findNavController()
                ?.navigate(QuizEndFragmentDirections.actionQuizEndFragmentToQuizFragment())
        }
    }
}