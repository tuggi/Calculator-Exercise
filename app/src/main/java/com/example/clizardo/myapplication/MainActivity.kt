package com.example.clizardo.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var valueOne: Int = 0
    private var valueTwo: Int = 0
    private var operation: String = ""
    private var answer: Int = 0
    private var grabbedValueOne: Boolean = false
    private var clickedEqual: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun displayNumber(view: View){
//        Toast.makeText(this, calculatorField.text, Toast.LENGTH_SHORT).show()
        if(calculatorField.text == "0" || this.grabbedValueOne || this.clickedEqual){
            calculatorField.setText("")
            calculatorField.append(view.getTag().toString())
            if(this.grabbedValueOne){
                grab()
            }
            this.clickedEqual = false
        } else {
            calculatorField.append(view.getTag().toString())
        }
    }

    fun displayNumber(){
        calculatorField.setText(this.answer)
    }

    fun clear(view: View){
        Toast.makeText(this, calculatorField.text, Toast.LENGTH_SHORT).show()
        calculatorField.setText("0")
//        Toast.makeText(this, view.toString(), Toast.LENGTH_SHORT).show()
    }

    fun getValueOne(view: View) {
        this.operation = view.getTag().toString()
        this.valueOne = Integer.parseInt(calculatorField.text.toString())
        grab()
    }

    fun grab(){
        this.grabbedValueOne = !this.grabbedValueOne
    }

    fun compute(view: View){
        Toast.makeText(this, this.operation, Toast.LENGTH_SHORT).show()
        this.valueTwo = Integer.parseInt(calculatorField.text.toString())
        when(this.operation){
            "+" -> this.answer = this.valueOne + this.valueTwo
            "−" -> this.answer = this.valueOne - this.valueTwo
            "×" -> this.answer = this.valueOne * this.valueTwo
            "÷" -> this.answer = this.valueOne / this.valueTwo
            else -> calculatorField.setText("ERROR")
        }
        this.clickedEqual = true
//        this.displayNumber()
//        display answer
    }
}
