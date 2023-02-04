package com.example.project1

import android.os.Bundle
import android.text.InputFilter
import android.text.InputFilter.LengthFilter
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.project1.R.id.guessfield


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val tries = findViewById<TextView>(R.id.tries)
        val subbutt = findViewById<Button>(R.id.subbutton)
        val scoredisplay = findViewById<TextView>(R.id.score)
        val  gfield = findViewById<EditText>(guessfield)
        gfield.setFilters(arrayOf<InputFilter>(LengthFilter(4)))
        var inputt  = gfield.text.toString()
        var boola = booleanArrayOf(false, false, false, false)
        val maxTries = 3
        var currTries = 0
        var failed = false
        var random = kotlin.random.Random
        var randomNumber = random.nextInt(5)
        val words = arrayOf("ship", "lend", "fast", "slow", "burn")


        subbutt.setOnClickListener {
            currTries++
            if (currTries==maxTries) {
                randomNumber = random.nextInt(5)
                boola.fill(false)
                currTries = 0
                failed=true
            }
            println("the answer is " + words[randomNumber].uppercase())
            tries.text=(maxTries-currTries-1).toString()
            var inputt  = gfield.text.toString().toUpperCase()
           scoredisplay.text=inputt
            var chosen = words[randomNumber].uppercase()
            for (i in 0..inputt.length-1) {
                if(inputt[i]== chosen[i]){
                   // println(words[randomNumber].uppercase())
                    boola[i]=true
                }
                //println(inputt[i])

            }
            var modifiedInput = ""
            for (i in 0..3) {
                if (boola[i] == true) {
                    modifiedInput += "O"
                } else {
                    modifiedInput += "X"
                }
            }
            scoredisplay.text = modifiedInput
            //Log.v("Blue cat", inputt)
            if(failed){scoredisplay.text ="failed" }
        }


    }
}