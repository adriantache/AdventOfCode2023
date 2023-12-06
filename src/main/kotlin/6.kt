package aoc23

import kotlin.math.*

fun main() {
    val input = INPUT.split("\n").filterNot { it.isBlank() }
    val times = input[0].split(" ").filterNot { it.isBlank() }
    val distances = input[1].split(" ").filterNot { it.isBlank() }
    val races = times.drop(1).zip(distances.drop(1))
    val raceValues = races.map { getValues(it.first.toDouble(), it.second.toDouble()) }
    val result = raceValues.reduce { acc, i -> i * acc }
    println("Result: $result")

    val time = input[0].replace(" ", "").split(":").filterNot { it.isBlank() }.drop(1).first()
    val distance = input[1].replace(" ", "").split(":").filterNot { it.isBlank() }.drop(1).first()
    val raceValue = getValues(time.toDouble(), distance.toDouble())
    println("Result 2: $raceValue")
}

private fun getValues(time: Double, record: Double): Int {
    val target = record + 1
    val core: Double = sqrt(time.pow(2) - 4 * target)
    val aMin: Int = ceil((time - core) / 2).roundToInt()
    val aMax: Int = floor((core + time) / 2).roundToInt()

    return aMax - aMin + 1
}

private const val TEMP = """
Time:      7  15   30
Distance:  9  40  200
"""

private const val INPUT = """
Time:        54     70     82     75
Distance:   239   1142   1295   1253
"""