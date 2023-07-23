package com.example.clacuclator

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    val currentExpression: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    fun addElem(c: Char) {
        currentExpression.value += c
    }

    fun delLast() {
        if (currentExpression.value!!.isNotEmpty() && (currentExpression.value!!.last() != '('
                    || currentExpression.value!!.last() != ')')
        )
            currentExpression.value = currentExpression.value!!.dropLast(1)
        else {
            currentExpression.value = currentExpression.value!!.dropLast(1)
            countOfBrackets--
        }
    }

    fun clear() {
        currentExpression.value = ""
    }

    fun equal(expression: String) {
        try {
            val cLogic = CLogic()
            currentExpression.value =
                cLogic.calculateRPN(cLogic.readNotation(expression)).toString()
        } catch (e: Exception) {
            currentExpression.value = "ERROR"
        }

    }

    private var countOfBrackets = 0
    fun brackets() {
        val ex = currentExpression.value
        if (countOfBrackets == 0) {
            currentExpression.value += '('
            countOfBrackets++
        } else if (ex?.last()!!.isDigit() && ex.last() == ')') {
            currentExpression.value += '('
            countOfBrackets++
        } else if (countOfBrackets % 2 != 0 && ex.last().isDigit()) {
            currentExpression.value += ')'
            countOfBrackets++
        } else {
            currentExpression.value += ')'
            countOfBrackets++
        }
    }
}