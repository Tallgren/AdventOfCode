package AoC2019.D1

import java.io.IOException
import java.nio.file.Files
import java.nio.file.Paths

//take its mass, divide by three, round down, and subtract 2.
fun fuelCounter() {
    val input = readLines()
    val modulesSum: Int = moduleIterator(input)
    println(modulesSum)
}

fun moduleIterator(inputList: List<String>): Int {
    var sum: Int = 0
    for(element in inputList) {
        sum += calculateFuelOfModules(Integer.parseInt(element))
    }
    return sum
}

//Rekursion
fun calculateFuelOfModules(f: Int): Int {
    var sum: Int = 0

    fun fuelAccumalator(f: Int): Int {
        val fuel = f/3-2
        return if (fuel <= 0) f
        else {
            sum += fuel
            fuelAccumalator(fuel)
        }
    }
    fuelAccumalator(f)
    return sum
}

fun readLines(): List<String> {
    val fileName = "C:\\Users\\Toby9\\IdeaProjects\\AdventOfCode\\src\\AoC2019\\D1\\input.txt"
    return try {
        Files.readAllLines(Paths.get(fileName))
    } catch (e: IOException) {
        e.printStackTrace()
        emptyList()
    }
}

fun main() {
    fuelCounter()
}