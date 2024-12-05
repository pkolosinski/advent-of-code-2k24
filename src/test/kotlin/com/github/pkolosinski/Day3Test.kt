package com.github.pkolosinski;

import kotlin.test.Test
import kotlin.test.assertEquals

class Day3Test {

    @Test
    fun `test solution 1`() {
        val file = "3.txt"
        val expected = 161

        val res = Day3.solution1(file)

        assertEquals(expected, res)
    }

    @Test
    fun `test solution 2`() {
        val file = "3.txt"
        val expected = 48

        val res = Day3.solution2(file)

        assertEquals(expected, res)
    }
}
