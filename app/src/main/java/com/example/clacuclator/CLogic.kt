package com.example.clacuclator

import java.util.Stack

class CLogic {
    private fun isDelim(c: Char) = c in " ="


    private fun isOper(c: Char) = c in "+-*/^()"


    private fun getPriority(c: Char): Int {
        return when (c) {
            '(' -> 0
            ')' -> 1
            '+' -> 2
            '-' -> 3
            '/' -> 4
            '*' -> 4
            '^' -> 5
            else -> 6
        }
    }

    fun readNotation(infixForm: String): String {
        var ans = ""
        val stack: Stack<Char> = Stack()

        var i = 0
        while (i < infixForm.length) {
            if (isDelim(infixForm[i])) {
                i++
                continue
            }

            if (infixForm[i].isDigit()) {
                while (!isOper(infixForm[i]) && !isDelim(infixForm[i])) {
                    ans += infixForm[i++]
                    if (i == infixForm.length)
                        break
                }

                ans += " "
                --i
            }

            if (isOper(infixForm[i])) {
                if (infixForm[i] == '(')
                    stack.push(infixForm[i])
                else if (infixForm[i] == ')') {
                    var e = stack.pop()
                    while (e != '(') {
                        ans += "$e "
                        e = stack.pop()
                    }
                } else {
                    if (stack.isNotEmpty())
                        if (getPriority(infixForm[i]) <= getPriority(stack.peek()))
                            ans += stack.pop()

                    stack.push(infixForm[i])
                }
            }

            i++
        }
        for (e in stack)
            ans += e

        return ans
    }

    fun calculateRPN(input: String): Double {
        var ans = 0.0
        val stack = Stack<Double>()

        var i = 0
        while (i < input.length) {

            if (input[i].isDigit()) {
                var a = ""

                while (!isDelim(input[i]) && !isOper(input[i])) {
                    a += input[i]
                    i++
                    if (i == input.length) break
                }
                stack.push(a.toDouble())
                i--
            } else if (isOper(input[i])) {
                val a = stack.pop()
                val b = stack.pop()

                when (input[i]) {
                    '+' -> ans = b + a
                    '-' -> ans = b - a
                    '*' -> ans = b * a
                    '/' -> ans = b / a
                    '^' -> ans = Math.pow(b, a)
                    '%' -> ans = b % a
                }
                stack.push(ans)
            }
            i++
        }
        return stack.peek()

    }
}