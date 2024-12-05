package com.github.pkolosinski

import java.util.*
import kotlin.math.abs

fun main() {
    println(Day1.solution1("1.txt"))
    println(Day1.solution2("1.txt"))
}

object Day1 {
    fun solution1(inputFile: String): Int {
        val data: List<Pair<Int, Int>> = prepareData(inputFile)
        val length = data.size

        val firstHeap: PriorityQueue<Int> = PriorityQueue(length)
        val secondHeap: PriorityQueue<Int> = PriorityQueue(length)

        data.forEach { pair ->
            firstHeap.add(pair.first)
            secondHeap.add(pair.second)
        }

        return calculateTotalDistance(firstHeap, secondHeap)
    }

    private fun calculateTotalDistance(
        firstHeap: PriorityQueue<Int>,
        secondHeap: PriorityQueue<Int>
    ): Int {
        var sum = 0

        for (i in 0..<firstHeap.size) {
            val first = firstHeap.remove()
            val second = secondHeap.remove()
            sum += abs(first - second)
        }

        return sum
    }

    fun solution2(inputFile: String): Int {
        val data: List<Pair<Int, Int>> = prepareData(inputFile)
        val length = data.size

        val firstColumn: List<Int> = data.map { it.first }
        val secondColumnByCount: MutableMap<Int, Int> = hashMapOf()

        data.map { it.second }.forEach { number ->
            val currentCount = secondColumnByCount.getOrDefault(number, 0)
            secondColumnByCount[number] = currentCount + 1
        }

        return calculateTotalSimilarityScore(firstColumn, secondColumnByCount)
    }

    private fun calculateTotalSimilarityScore(
        firstColumn: List<Int>,
        secondColumnByCount: Map<Int, Int>
    ): Int {
        return firstColumn.sumOf { number ->
            val count = secondColumnByCount.getOrDefault(number, 0)
            number * count
        }
    }

    private fun prepareData(inputFile: String): List<Pair<Int, Int>> {
        val input: List<String> = readInputAsList(inputFile)
        return input.map { pair -> pair.split("   ").map { it.toInt() } }
            .map { Pair(it[0], it[1]) }
    }
}
