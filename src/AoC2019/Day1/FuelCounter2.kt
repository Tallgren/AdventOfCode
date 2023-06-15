package AoC2019.Day1

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
    //itererar genom listan, kör calculateFuelOfModules på varje element och summerar
    return inputList.map(String::toInt).sumBy { calculateFuelOfModules2(it) }
}

//Rekursion
fun calculateFuelOfModules2(f: Int): Int {
    //mer simplistiskt rekursion
    return if(f/3-2 < 0) 0
    else {
        val fuel = f/3-2
        fuel + calculateFuelOfModules2(fuel)
    }
}

fun readLines2(): List<String> {
    val fileName = "src/AoC2019/Day1/input.txt"
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