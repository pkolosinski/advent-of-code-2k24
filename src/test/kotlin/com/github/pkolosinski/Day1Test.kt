package com.github.pkolosinski

import kotlin.test.Test
import kotlin.test.assertEquals

class Day1Test {

    @Test
    fun `test solution 1`() {
        val file = "1.txt"
        val expected = 11

        val res = Day1.solution1(file)

        assertEquals(res, expected)
    }

    @Test
    fun `test solution 2`() {
        val file = "1.txt"
        val expected = 31

        val res = Day1.solution2(file)

        assertEquals(res, expected)
    }
}