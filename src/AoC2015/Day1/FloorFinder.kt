package AoC2015.Day1

import java.io.IOException
import java.nio.file.Files
import java.nio.file.Paths

fun floorFinder() {
    val input = readLines()
    val result = findFloor(input)
    println(result)

    val result2 = findPosBasement(input)
    println(result2)
}

fun findPosBasement(input: CharArray): Int {
    var sum = 0
    var counter = 0
    for (element in input) {
        counter++
        if (element == '(') sum++
        else if (element == ')') sum--

        if (sum == -1) {
            return counter
        }
    }
    return sum
}

fun findFloor(input: CharArray): Int {
    var sum = 0
    for (element in input) {
        if (element == '(') sum++
        else if (element == ')') sum--
    }

    return sum
}

fun readLines(): CharArray {
    val fileName = "src/AoC2015/Day1/input.txt"
    return try {
        Files.readString(Paths.get(fileName)).toCharArray()
    } catch (e: IOException) {
        e.printStackTrace()
        charArrayOf()
    }
}


fun main() {
    floorFinder()
}