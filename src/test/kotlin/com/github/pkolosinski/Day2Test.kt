package com.github.pkolosinski

import kotlin.test.Test
import kotlin.test.assertEquals

class Day2Test {

    @Test
    fun `test solution 1`() {
        val file = "2.txt"
        val expected = 2

        val res = Day2.solution1(file)

        assertEquals(expected, res)
    }

    @Test
    fun `test solution 2`() {
        val file = "2.txt"
        val expected = 4

        val res = Day2.solution2(file)

        assertEquals(expected, res)
    }
}