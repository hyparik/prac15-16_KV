package com.example.geoquiz

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import com.example.geoquiz.R.id.prev_button

class activity_main : AppCompatActivity() {
    lateinit var trueButton: Button
    lateinit var falseButton: Button
    lateinit var nextButton: ImageButton
    lateinit var prevButton: ImageButton
    lateinit var questionTextView: TextView

    val questionBank = listOf(
        Question(R.string.Question_1, true),
        Question(R.string.Question_2, false),
        Question(R.string.Question_3, true),
        Question(R.string.Question_4, true),
        Question(R.string.Question_5, true)
    )
    var currentIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        trueButton = findViewById(R.id.true_button)
        falseButton = findViewById(R.id.false_button)
        nextButton = findViewById(R.id.next_button)
        prevButton = findViewById(R.id.prev_button)
        questionTextView = findViewById(R.id.Question)
        fun checkAnswer(userAnswer: Boolean){
            val correctAnswer = questionBank[currentIndex].answer
            val messageResId = if(userAnswer == correctAnswer){
                R.string.correct
            }else{
                R.string.incorrect
            }
            Toast.makeText(this, messageResId, Toast.LENGTH_SHORT).show()
        }
        trueButton.setOnClickListener { view: View ->
            checkAnswer(true)
        }
        falseButton.setOnClickListener { view: View ->
            checkAnswer(false)
        }
        fun updateQuestion(){val questionTextResId = questionBank[currentIndex].textResId
            questionTextView.setText((questionTextResId))}
        nextButton.setOnClickListener { currentIndex = (currentIndex + 1) % questionBank.size
        updateQuestion()}
        prevButton.setOnClickListener { currentIndex = (currentIndex - 1) % questionBank.size
            updateQuestion()}
        updateQuestion()
        val questionTextResId = questionBank[currentIndex].textResId
        questionTextView.setText((questionTextResId))
    }
    }
