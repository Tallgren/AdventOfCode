package AoC2018.Day1

import java.io.IOException
import java.nio.file.Files
import java.nio.file.Paths

fun frequencyCalibrator2() {
    val input = readLines2()
    val result = calibrate2(input)
    println(result)
    val result2 = findFirstFrequencyReachedTwice2(input)
    println(result2)
}

fun calibrate2(inputList: List<String>): Int {
    //mappar till int och använder reduce för att summera
    return inputList.map(String::toInt).reduce{ acc, i -> acc + i }
}

fun findFirstFrequencyReachedTwice2(inputList: List<String>): Int {
    var frequency: Int = 0
    val frequencyList = mutableListOf<Int>()
    var i = 0
    //ny break istället för while true
    while(frequency !in frequencyList) {
        frequencyList.add(frequency)
        //[i % inputList.size] kan användas för att loopa runt till början av en lista
        frequency += inputList.map(String::toInt)[i % inputList.size]
        i++
    }
    return frequency
}

fun readLines2(): List<String> {
    val fileName = "src/AoC2018/Day1/input.txt"
    return try {
        Files.readAllLines(Paths.get(fileName))
    } catch (e: IOException) {
        e.printStackTrace()
        emptyList()
    }
}

fun main() {
    frequencyCalibrator2()
}