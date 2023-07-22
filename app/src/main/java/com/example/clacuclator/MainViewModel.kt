package com.example.clacuclator

import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    var currentExpression = ""

    private fun addElem(c: Char) {
        currentExpression += c
    }

    private fun delLast() {
        if (currentExpression.isNotEmpty())
            currentExpression.dropLast(1)
    }

    private fun clear(){
        currentExpression = ""
    }

    private fun equal(expression: String){
        val cLogic = CLogic()
        currentExpression = cLogic.calculateRPN(cLogic.readNotation(expression)).toString()

    }
}