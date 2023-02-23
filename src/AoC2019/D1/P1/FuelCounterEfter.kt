package AoC2019.D1.P1

import java.io.IOException
import java.nio.file.Files
import java.nio.file.Paths

//take its mass, divide by three, round down, and subtract 2.
fun fuelCounter2() {
    val input = readLines2()
    val modulesSum: Int = moduleIterator2(input)
    println(modulesSum)
}

fun moduleIterator2(inputList: List<String>): Int {
    //bra mycket lättare att mappa och summera på en rad
    return inputList.map(String::toInt).sumBy { it/3-2 }
}

fun readLines2(): List<String> {
    val fileName = "C:\\Users\\Toby9\\IdeaProjects\\AdventOfCode\\src\\AoC2019\\D1\\input.txt"
    return try {
        Files.readAllLines(Paths.get(fileName))
    } catch (e: IOException) {
        e.printStackTrace()
        emptyList()
    }
}

fun main() {
    fuelCounter2()
}