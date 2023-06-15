package AoC2015.Day1

import java.io.IOException
import java.nio.file.Files
import java.nio.file.Paths

fun floorFinder2() {
    val input = readLines2()
    val result = findFloor2(input)
    println(result)

    val result2 = findPosBasement2(input)
    println(result2)
}

fun findPosBasement2(input: CharArray): Int {
    //instantierar en char för floor up och en variabel currentfloor och position
    val FLOOR_UP_CHAR = '('
    var currentFloor = 0
    var position = 1
    for (element in input) {
        //använder when istället för if
        when (element) {
            FLOOR_UP_CHAR -> currentFloor++
            else -> currentFloor--
        }
        //breakar när vi når basement
        if (currentFloor < 0) break

        position++
    }
    return position
}

fun findFloor2(input: CharArray): Int {
    //instantierar en char för floor up och en variabel currentfloor
    val FLOOR_UP_CHAR = '('
    var currentFloor = 0
    for (element in input) {
        //använder when istället för if
        when (element) {
        FLOOR_UP_CHAR -> currentFloor++
        else -> currentFloor--
        }
    }
    return currentFloor
}

fun readLines2(): CharArray {
    val fileName = "src/AoC2015/Day1/input.txt"
    return try {
        Files.readString(Paths.get(fileName)).toCharArray()
    } catch (e: IOException) {
        e.printStackTrace()
        charArrayOf()
    }
}


fun main() {
    floorFinder2()
}