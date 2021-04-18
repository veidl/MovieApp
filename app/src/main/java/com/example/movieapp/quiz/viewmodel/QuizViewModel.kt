package com.example.movieapp.quiz.viewmodel

import android.os.CountDownTimer
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.movieapp.R
import com.example.movieapp.quiz.data.Question
import com.example.movieapp.quiz.data.QuestionCatalogue

class QuizViewModel : ViewModel() {


    private val _questions = MutableLiveData<MutableList<Question>>()
    val questions: LiveData<MutableList<Question>>
        get() = _questions

    private val _currentQuestion = MutableLiveData<Question>()
    val currentQuestion: LiveData<Question>
        get() = _currentQuestion

    private val _score = MutableLiveData<Int>()
    val score: LiveData<Int>
        get() = _score

    private val _index = MutableLiveData<Int>()
    val index: LiveData<Int>
        get() = _index

    private val _gameEnd = MutableLiveData<Boolean>()
    val gameEnd: LiveData<Boolean>
        get() = _gameEnd

    private val _wrongInput = MutableLiveData<Boolean>()
    val wrongInput: LiveData<Boolean>
        get() = _wrongInput

    private val _time = MutableLiveData<Long>()
    val time: LiveData<Long>
        get() = _time

    lateinit var timer: CountDownTimer

    init {
        Log.i("QuizViewModel", "Model created")
        initQuestions()
        initTimer(COUNTDOWN_TIME)
    }

    private fun initQuestions() {
        _questions.value = QuestionCatalogue().defaultQuestions
        _score.value = 0
        _index.value = 0
        _currentQuestion.value = _questions.value!![_index.value!!]
        _gameEnd.value = false
    }


    fun initTimer(time: Long) {
        timer = object : CountDownTimer(time, ONE_SECOND) {
            override fun onTick(millisUntilFinished: Long) {
                updateTimer(millisUntilFinished)
            }

            override fun onFinish() {
                onEndGame()
            }
        }
        timer.start()
    }

    fun onNextQuestion(answerId: Int) {
        val questionIndex = checkAnswer(answerId)

        if (_questions.value!![_index.value!!].answers[questionIndex].isCorrectAnswer)
            incrementScore()

        if (_index.value!!.plus(1) > _questions.value!!.size.minus(1)) {
            _gameEnd.value = true
            return
        }
        incrementIndex()
        _currentQuestion.value = _questions.value!![_index.value!!]
    }

    fun stopTimer() {
        timer.cancel()
    }

    private fun checkAnswer(answerId: Int): Int {
        return when (answerId) {
            R.id.answer1 -> 0
            R.id.answer2 -> 1
            R.id.answer3 -> 2
            R.id.answer4 -> 3
            else -> throw IndexOutOfBoundsException("Question only have four answers")
        }
    }

    private fun updateTimer(timeInMs: Long) {
        _time.value = timeInMs
    }

    private fun onEndGame() {
        _gameEnd.value = true
    }

    private fun incrementScore() {
        _score.value = _score.value?.plus(1)
    }

    private fun incrementIndex() {
        _index.value = _index.value?.plus(1)
    }

    override fun onCleared() {
        super.onCleared()
        Log.i("QuizViewModel", "Model destroyed")
    }

    companion object {
        private const val ONE_SECOND = 1000L
        private const val COUNTDOWN_TIME = 60000L
    }

}