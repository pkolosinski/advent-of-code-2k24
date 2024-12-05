package com.github.pkolosinski

import kotlin.math.abs

fun main() {
    println(Day2.solution1("2.txt"))
    println(Day2.solution2("2.txt"))
}

object Day2 {
    fun solution1(inputFile: String): Int {
        val data: List<List<Int>> = prepareData(inputFile)

        return data.filter(::isReportSave).size
    }

    private fun isReportSave(report: List<Int>): Boolean {
        return findFaultIndex(report) < 0
    }

    fun solution2(inputFile: String): Int {
        val data: List<List<Int>> = prepareData(inputFile)

        return data.filter(::isReportSaveWithFaultTolerance).size
    }

    private fun isReportSaveWithFaultTolerance(report: List<Int>): Boolean {
        val faultIndex = findFaultIndex(report)
        return faultIndex < 0 || isReportSave(report.withoutElementAt(faultIndex))
                || isReportSave(report.withoutElementAt(faultIndex + 1))
    }

    private fun findFaultIndex(report: List<Int>): Int {
        for (i in 0..<report.size - 1) {
            if (abs(report[i] - report[i + 1]) > 3) {
                return i
            }
            if (i == 0) {
                if ((report[i] - report[i + 1]).sign() != (report[i + 1] - report[i + 2]).sign()) {
                    return i
                }
            } else if ((report[i - 1] - report[i]).sign() != (report[i] - report[i + 1]).sign()) {
                return i
            }
        }
        return -1
    }

    private fun Int.sign(): Int = when {
        this > 0 -> 1
        this == 0 -> 0
        else -> -1
    }

    private fun List<Int>.withoutElementAt(index: Int) = this.filterIndexed { i, _ -> i != index }

    private fun prepareData(inputFile: String): List<List<Int>> {
        val input: List<String> = readInputAsList(inputFile)
        return input.map { line -> line.split(" ").map { it.toInt() } }
    }
}