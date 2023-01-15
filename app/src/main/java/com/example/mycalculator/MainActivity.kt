package com.example.mycalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private var tvInput : TextView? = null
    var LastNumeric : Boolean = false
    var LastDot : Boolean = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvInput = findViewById(R.id.tvInput)
    }


    fun onDigit(view: View) {
        tvInput?.append((view as Button).text)
        LastNumeric= true
        LastDot=false
    }

    fun onClear(view: View){
        tvInput?.text=""
    }

    fun onDecimalPoint(view: View){
        if(LastNumeric && !LastDot){
            tvInput?.append(".")
            LastNumeric= false
            LastDot= true
        }
    }
    fun onOperator(view: View) {
        tvInput?.text?.let {
            if (LastNumeric && !isOperatorAdded(it.toString())) {
                tvInput?.append((view as Button).text)
                LastNumeric= false
                LastDot= false
            }
        }
    }
    fun onEqual(view: View){
        if(LastNumeric){
            var tvValue = tvInput?.text.toString()
            try {

            }catch (e:ArithmeticException){

            }
        }
    }
    private fun isOperatorAdded(value: String): Boolean {
        return if (value.startsWith("-")) {
            false
        } else {
            value.contains("/")
                    || value.contains("*")
                    || value.contains("+")
                    || value.contains("-")
        }
    }



}


