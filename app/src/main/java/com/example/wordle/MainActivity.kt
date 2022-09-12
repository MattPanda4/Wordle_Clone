package com.example.wordle

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView


class MainActivity : AppCompatActivity() {


    private val wordToGuess = FourLetterWordList.FourLetterWordList.getRandomFourLetterWord()



    @SuppressLint("CutPasteId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var guessInput: String

        val guessInput1: TextView = findViewById(R.id.guessOneInput)
        val guessInput2: TextView = findViewById(R.id.guessTwoInput)
        val guessInput3: TextView = findViewById(R.id.guessThreeInput)

        val guessInputCheck1: TextView = findViewById(R.id.GuessOneInputCheck)
        val guessInputCheck2: TextView = findViewById(R.id.GuessTwoInputCheck)
        val guessInputCheck3: TextView = findViewById(R.id.GuessThreeInputCheck)

        val word: TextView = findViewById(R.id.wordToGuess)

        word.text = wordToGuess
        word.visibility = View.INVISIBLE

        guessInput1.text = ""
        guessInput2.text = ""
        guessInput3.text = ""

        guessInputCheck1.text = ""
        guessInputCheck2.text = ""
        guessInputCheck3.text = ""


            val button = findViewById<Button>(R.id.inputButton3)

            button.setOnClickListener {
                val editText = findViewById<EditText>(R.id.textInput)
                guessInput = editText.text.toString()
                guessInput1.text = guessInput
                guessInputCheck1.text = checkGuess(guessInput)
                button.visibility = View.GONE
            }

            val button2 = findViewById<Button>(R.id.inputButton2)
            button2.setOnClickListener {
                val editText2 = findViewById<EditText>(R.id.textInput)
                guessInput = editText2.text.toString()
                guessInput2.text = guessInput
                guessInputCheck2.text = checkGuess(guessInput)
                button2.visibility = View.GONE
            }

            val button3 = findViewById<Button>(R.id.inputButton)
            button3.setOnClickListener {
                val editText3 = findViewById<EditText>(R.id.textInput)
                guessInput = editText3.text.toString()
                guessInput3.text = guessInput
                guessInputCheck3.text = checkGuess(guessInput)
                button3.visibility = View.GONE
                word.visibility = View.VISIBLE
            }

    }

   private fun checkGuess(guess: String) : String {
        var result = ""
        for (i in 0..3) {
            if (guess[i] == wordToGuess[i]) {
                result += "O"
            }
            else if (guess[i] in wordToGuess) {
                result += "+"
            }
            else {
                result += "X"
            }
        }
        return result
    }

}