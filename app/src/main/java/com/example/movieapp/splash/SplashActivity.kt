package com.example.movieapp.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.example.movieapp.MainActivity
import com.example.movieapp.R

class SplashActivity : AppCompatActivity() {
    private val SPLASH_SCREEN_TIMEOUT: Long = 2000L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_activity)

        this.loadSplashScreen()
    }

    private fun startMainActivity() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

    private fun loadSplashScreen() {
        Handler(Looper.getMainLooper()).postDelayed({
            startMainActivity()
        }, SPLASH_SCREEN_TIMEOUT)
    }
}