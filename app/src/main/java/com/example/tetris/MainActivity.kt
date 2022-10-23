package com.example.tetris

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.tetris.storage.AppPreferences
import com.google.android.material.snackbar.Snackbar
import kotlin.system.exitProcess

class MainActivity : AppCompatActivity() {

    private var tvHighScore: TextView? = null
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()
        val preferences = AppPreferences(this)
        val btnResetScore = findViewById<Button>(R.id.btn_reset_score)
        val btnNewGame = findViewById<Button>(R.id.btn_new_game)
        val btnExit = findViewById<Button>(R.id.btn_exit)
        tvHighScore = findViewById(R.id.tv_high_score)
        tvHighScore?.text = "High score: ${preferences.getHighScore()}"

        btnNewGame.setOnClickListener(this::onBtnNewGameClick)
        btnExit.setOnClickListener(this::onBtnExitClick)
        btnResetScore.setOnClickListener(this::onBtnResetScoreClick)
    }

    @SuppressLint("SetTextI18n")
    override fun onResume() {
        super.onResume()
        val preferences = AppPreferences(this)
        tvHighScore?.text = "High score: ${preferences.getHighScore()}"
    }

    @SuppressLint("SetTextI18n")
    private fun onBtnResetScoreClick(view:View) {
        val preferences = AppPreferences(this)
        preferences.clearHighScore()
        tvHighScore?.text = "High score: ${preferences.getHighScore()}"
        Snackbar.make(view,"Score successfully reset",Snackbar.LENGTH_SHORT).show()
    }

    private fun onBtnExitClick(view:View) {
        exitProcess(0)
    }

    private fun onBtnNewGameClick(view: View) {
        val intent = Intent(this,GameActivity::class.java)
        startActivity(intent)
    }
}

