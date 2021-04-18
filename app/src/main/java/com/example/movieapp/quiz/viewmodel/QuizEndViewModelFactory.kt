package com.example.movieapp.quiz.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider


class QuizEndViewModelFactory(private val finalScore: Int, private val questionCount: Int) :
    ViewModelProvider.Factory {


    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(QuizEndViewModel::class.java)) {
            return QuizEndViewModel(finalScore, questionCount) as T
        } else {
            throw IllegalArgumentException("ViewModel is not defined")
        }
    }
}