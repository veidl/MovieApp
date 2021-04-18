package com.example.movieapp.quiz.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.movieapp.R
import com.example.movieapp.databinding.FragmentQuizBinding
import com.example.movieapp.quiz.data.Answer
import com.example.movieapp.quiz.viewmodel.QuizViewModel


class QuizFragment : Fragment() {

    private lateinit var binding: FragmentQuizBinding
    private lateinit var viewModel: QuizViewModel

    private var timeLeft: Long = 0L

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_quiz, container, false)

        viewModel = ViewModelProvider(this).get(QuizViewModel::class.java)

        binding.quizViewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        viewModel.gameEnd.observe(viewLifecycleOwner, { isEnd -> endGame(isEnd) })

        viewModel.time.observe(viewLifecycleOwner, { timeLeft = it })

        viewModel.wrongInput.observe(viewLifecycleOwner, {
            Toast.makeText(
                activity,
                "Please choose an answer.",
                Toast.LENGTH_SHORT
            ).show()
        })

        binding.btnNext.setOnClickListener {
            nextQuestion()
        }

        return binding.root
    }

    private fun endGame(isEnd: Boolean) {
        if (isEnd) {
            viewModel.timer.cancel()
            view?.findNavController()
                ?.navigate(
                    QuizFragmentDirections.actionQuizFragmentToQuizEndFragment(
                        viewModel.score.value!!,
                        viewModel.questions.value!!.size
                    )
                )
        }

    }

    private fun nextQuestion() {
        val checkedAnswer = binding.answerBox.checkedRadioButtonId

        if (-1 == checkedAnswer) {
            Toast.makeText(
                activity,
                "Please choose an answer.",
                Toast.LENGTH_SHORT
            ).show()
            return
        }

        viewModel.onNextQuestion(checkedAnswer)
        binding.answerBox.clearCheck()
    }

    override fun onPause() {
        Log.i("QuizFragment", "onPause")
        viewModel.stopTimer()
        super.onPause()
    }

    override fun onResume() {
        Log.i("QuizFragment", "onResume")
        if(timeLeft != 0L)
            viewModel.initTimer(timeLeft)
        super.onResume()
    }
}