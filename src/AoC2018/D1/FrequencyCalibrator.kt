package AoC2018.D1

import java.io.IOException
import java.nio.file.Files
import java.nio.file.Paths

fun frequencyCalibrator() {
    val input = readLines()
    val result = calibrate(input)
    println(result)
    val result2 = findFirstFrequencyReachedTwice(input)
    println(result2)
}

fun calibrate(inputList: List<String>): Int {
    var frequency: Int = 0

    for (element in inputList) {
        frequency += Integer.parseInt(element)
    }

    return frequency
}

fun findFirstFrequencyReachedTwice(inputList: List<String>): Int {
    var frequency: Int = 0
    val frequencyList = mutableListOf<Int>(frequency)
    while(true) {
        for (element in inputList) {
            frequency += Integer.parseInt(element)
            if (frequencyList.any { it == frequency }) {
                return frequency
            }
            frequencyList.add(frequency)
        }
    }
}

fun readLines(): List<String> {
    val fileName = "C:\\Users\\Toby9\\IdeaProjects\\AdventOfCode\\src\\AoC2018\\D1\\input.txt"
    return try {
        Files.readAllLines(Paths.get(fileName))
    } catch (e: IOException) {
        e.printStackTrace()
        emptyList()
    }
}

fun main() {
    frequencyCalibrator()
}