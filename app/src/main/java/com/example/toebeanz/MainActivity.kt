package com.example.toebeanz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_high_score.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Define needed variables
        var random = (0..3).random()
        val fourColors = arrayOf("Green", "Yellow", "Blue", "Red")
        val allColors: ArrayList<String> = arrayListOf(fourColors[random])
        val start = findViewById<Button>(R.id.startBtn)
        val info = findViewById<Button>(R.id.howBtn)
        val activitiesArray = arrayOf(Green::class.java)

        // Colours Toe Beanz
        for(i in 0..3){
            random = (0..3).random()
            allColors.add(fourColors[random])
        }

        // Start button used to begin game

        start.setOnClickListener{
            val intent = Intent(this@MainActivity, Green::class.java)
            intent.putStringArrayListExtra("colors", allColors)
            intent.putExtra("count", 0)
            intent.putExtra("score", 0)
            startActivity(intent)
        }

        info.setOnClickListener{
            val intent = Intent(this@MainActivity, HowToPlay::class.java)
            startActivity(intent)
        }


        //Highscore
        highScoreBtn.setOnClickListener{
            val intent = Intent(this@MainActivity, HighScore::class.java)
            intent.putExtra("SCORE", 0)
            startActivity(intent)
        }


    }
}