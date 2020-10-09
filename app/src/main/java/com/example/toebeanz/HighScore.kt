package com.example.toebeanz

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_high_score.*

class HighScore : AppCompatActivity() {


    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_high_score)

        val home = findViewById<Button>(R.id.homeBtn)
        val scoreLabel = findViewById<TextView>(R.id.scoreLabel)
        val highScoreLabel = findViewById<TextView>(R.id.highScoreLabel)

        val score = Intent().getIntExtra("SCORE", 0)
        scoreLabel.text = "" + score

        val settings = getSharedPreferences("GAME_DATA", Context.MODE_PRIVATE)
        val highScore = settings.getInt("HIGH_SCORE", 0)

        if (score > highScore) {
            highScoreLabel.text = "High Score : $score"

            //Save
            val editor = settings.edit()
            editor.putInt("HIGH_SCORE", score)
            editor.commit()
        } else {
            highScoreLabel.text = "High Score : $highScore"
        }
        home.setOnClickListener {
            val intent = Intent(this@HighScore, MainActivity::class.java)
            startActivity(intent)
        }
    }
}