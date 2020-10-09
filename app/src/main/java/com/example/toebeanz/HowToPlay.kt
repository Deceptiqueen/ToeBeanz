package com.example.toebeanz

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class HowToPlay : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_how_to_play)

        // Fetch buttons and text areas
        val title = findViewById<TextView>(R.id.titleText)
        val info = findViewById<Button>(R.id.startBtn)

        info.setOnClickListener {
            val intent = Intent(this@HowToPlay, MainActivity::class.java)
            startActivity(intent)
        }
    }
}