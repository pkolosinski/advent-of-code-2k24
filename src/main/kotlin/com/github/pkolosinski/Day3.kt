package com.github.pkolosinski

fun main() {
    println(Day3.solution1("3.txt"))
    println(Day3.solution2("3.txt"))
}

object Day3 {
    fun solution1(inputFile: String): Int {
        val text = readInputAsString(inputFile)
        val regex = Regex("""mul\((\d+),(\d+)\)""")

        val matchGroups: Sequence<MatchGroupCollection> = regex.findAll(text).map { it.groups }
        return matchGroups.sumOf(::multiplyMatchedNumbers)
    }

    private fun multiplyMatchedNumbers(matches: MatchGroupCollection): Int =
        extractMatchedNumbers(matches[1]!!) * extractMatchedNumbers(matches[2]!!)

    private fun extractMatchedNumbers(match: MatchGroup): Int = match.value.toInt()

    fun solution2(inputFile: String): Int {
        val text = readInputAsString(inputFile)
        val regex = Regex("""mul\((\d+),(\d+)\)|(do\(\))|(don't\(\))""")

        val matchGroups: Sequence<MatchGroupCollection> = regex.findAll(text).map { it.groups }
        return sumEnabledMultiplications(matchGroups)
    }

    private fun sumEnabledMultiplications(matchGroups: Sequence<MatchGroupCollection>): Int {
        var enabled = true
        var sum = 0
        for (group in matchGroups) {
            when (group[0]!!.value) {
                "do()" -> enabled = true
                "don't()" -> enabled = false
                else -> if (enabled) sum += multiplyMatchedNumbers(group)
            }
        }
        return sum
    }
}