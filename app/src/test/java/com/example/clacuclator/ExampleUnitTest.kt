package com.example.clacuclator

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    @Test
    fun toRPN() {
        val tp = CLogic().readNotation("3 + 4 * 2 / (1 - 5)^2")
        assertEquals("3 4 2 * 1 5 − 2 ^ / +", tp)
    }

    @Test
    fun calc(){
        val ans = CLogic().calculateRPN(CLogic().readNotation("3 4+"))
        assertEquals(7.toDouble(), ans, 0.01)
    }
}