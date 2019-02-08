package com.example.clizardo.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var valueOne: Int = 0
    private var valueTwo: Int = 0
    private var operation: String = ""
    private var answer: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    public fun displayNumber(view: View){
//        Toast.makeText(this, calculatorField.text, Toast.LENGTH_SHORT).show()
        if(calculatorField.text == "0"){
            calculatorField.setText("")
            calculatorField.append(view.getTag().toString())
        } else {
            calculatorField.append(view.getTag().toString())
        }
    }

    public fun clear(view: View){
        calculatorField.setText("0")
//        Toast.makeText(this, calculatorField.text, Toast.LENGTH_SHORT).show()
    }

    public fun getOperation():String ?{
        return this.operation
    }

    public fun compute(){
        when(this.getOperation()){
            "add" -> this.answer = this.valueOne + this.valueTwo
            "subtract" -> this.answer = this.valueOne - this.valueTwo
            "multiply" -> this.answer = this.valueOne * this.valueTwo
            "divide" -> this.answer = this.valueOne / this.valueTwo
            else -> calculatorField.setText("ERROR")
        }
//        display answer
    }
}
