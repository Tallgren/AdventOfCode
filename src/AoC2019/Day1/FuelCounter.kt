package AoC2019.Day1

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
    //bra mycket lättare att mappa och summera på en rad
    return inputList.map(String::toInt).sumBy { it/3-2 }
}

fun readLines(): List<String> {
    val fileName = "src/AoC2019/Day1/input.txt"
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