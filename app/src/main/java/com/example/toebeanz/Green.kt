package com.example.toebeanz

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Green : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_green)

        // Fetch buttons and text areas
        val title = findViewById<TextView>(R.id.titleText)
        val scoreText = findViewById<TextView>(R.id.scoreText)
        val green = findViewById<Button>(R.id.greenBtn)
        val yellow = findViewById<Button>(R.id.yellowBtn)
        val blue = findViewById<Button>(R.id.blueBtn)
        val red = findViewById<Button>(R.id.redBtn)
        val restart = findViewById<Button>(R.id.restartBtn)
        val activitiesArray = arrayOf(Green::class.java, Yellow::class.java, Blue::class.java, Red::class.java)

        // Get count, index and color from intent
        var score = intent.getIntExtra("score", -2)
        var count = intent.getIntExtra("count", -3)
        val colors = intent.getStringArrayListExtra("colors")

        // Update displayed score
        scoreText.text = score.toString()

        // Update title text
        if(score != count){
            val temp = "Color: " + (count + 1)
            title.text = temp
        } else {
            val temp = "CLick " + (colors?.get(count) ?:)
            title.text = temp
        }

        // Play lost or won the game
        fun gameOver(newTitle: String){
            colors?.set(count, newTitle)
            title.text = newTitle
            restart.visibility = View.VISIBLE
            red.text = newTitle
            yellow.text = newTitle
            green.text = newTitle
        }

        // Update game based on user's choice
        fun onCorrect(answer: String, classNum: Int){
            if (colors[count] == answer){
                val intent = Intent(this@Green, activitiesArray[classNum])
                if((count+1) == colors.size){
                    gameOver("YOU WIN!")
                } else {
                    if (count == score) {
                        count = -1
                        score++
                    }
                    count++
                    intent.putStringArrayListExtra("colors", colors)
                    intent.putExtra("count", count)
                    intent.putExtra("score", score)
                    startActivity(intent)
                }
            }
            else if(restart.visibility != 0){
                gameOver("gameOver")
            }
        }

        // On click listeners for each button
        green.setOnClickListener {
            onCorrect("Green", 0)
        }
        yellow.setOnClickListener {
            onCorrect("Yellow", 1)
        }
        blue.setOnClickListener {
            onCorrect("Blue", 2)
        }
        red.setOnClickListener {
            onCorrect("Red", 3)
        }
        restart.setOnClickListener {
            val intent = Intent(this@Green, MainActivity::class.java)
            startActivity(intent)
        }
    }
}

//package com.example.toebeanz
//
//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle
//import android.os.Handler
//import android.os.Looper
//import android.view.View
//import android.view.animation.AnimationUtils
//import android.widget.Button
//import android.widget.TextView
//import kotlinx.android.synthetic.main.activity_green.*
//import java.util.*
//import kotlin.random.Random
//
//
//class Green : AppCompatActivity() {
//    private lateinit var title:TextView
//    private lateinit var scoreText:TextView
//    private lateinit var green:Button
//    private lateinit var yellow:Button
//    private lateinit var blue:Button
//    private lateinit var red:Button
//    private lateinit var restart:Button
//
//
//    private var handler: Handler = Handler(Looper.getMainLooper())
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_green)
//
//        // Fetch buttons and textviews
//        title = findViewById<TextView>(R.id.titleText)
//        scoreText = findViewById<TextView>(R.id.scoreText)
//        green = findViewById<Button>(R.id.greenBtn)
//        yellow = findViewById<Button>(R.id.yellowBtn)
//        blue = findViewById<Button>(R.id.blueBtn)
//        red = findViewById<Button>(R.id.redBtn)
//        restart = findViewById<Button>(R.id.restartBtn)
//
//        //Get count, index and colour from intent
//        var score= intent.getIntExtra("score", -2)
//        var count =intent.getIntExtra("count", -3)
//        val colors = intent.getStringArrayListExtra("colors")
//        handler.postDelayed({
//            animatePattern()
//        }, 2000)
//    }
//    private var pattern:Array<Int> = emptyArray()
//    private var patternLength = 3
//    fun animatePattern(){
//        val fadeOut = AnimationUtils.loadAnimation(this, android.R.anim.fade_out)
//    //    greenBtn.startAnimation(fadeOut)
//        val random = Random(Calendar.getInstance().timeInMillis)
//        pattern = Array(patternLength){random.nextInt(4)}
//        for (i in pattern.indices){
//            var bn = pattern.get(i)
//            var delay = 1000*i
//            handler.postDelayed({
//                when(bn){
//                    0 -> greenBtn.startAnimation(fadeOut)
//                    1 -> yellowBtn.startAnimation(fadeOut)
//                    2 -> blueBtn.startAnimation(fadeOut)
//                    3 -> redBtn.startAnimation(fadeOut)
//                }
//            }, delay.toLong())
//        }
//
//
//
//    }
}