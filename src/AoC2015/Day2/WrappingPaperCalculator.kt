package AoC2015.Day2

import java.io.IOException
import java.nio.file.Files
import java.nio.file.Paths

//l*w*h
//2*l*w + 2*w*h + 2*h*l
//plus area of smallest side

fun wrappingPaperCalculator() {
    val input = readLines()
    val result = calculatePaperRequired(input)
    println(result)
    val result2 = calculateRibbonRequired(input)
    println(result2)
}

fun calculateRibbonRequired(input: List<String>): Int {
    var sum = 0
    val presentList = input.map { s -> s.split("x")}

    for (element in presentList) {
        val l = Integer.parseInt(element[0])
        val w = Integer.parseInt(element[1])
        val h = Integer.parseInt(element[2])
        val sideDiameter = listOf(l,w,h)
        val circumference = sideDiameter.sorted().dropLast(1).sum()*2
        val bow = l*w*h
        sum += circumference + bow
    }
    return sum
}

fun calculatePaperRequired(input: List<String>): Int {
    var sum = 0
    val presentList = input.map { s -> s.split("x")}

    for (element in presentList) {
        val l = Integer.parseInt(element[0])
        val w = Integer.parseInt(element[1])
        val h = Integer.parseInt(element[2])
        sum += (2*l*w + 2*w*h + 2*h*l)
        val sides = listOf(l*w,w*h,h*l).sorted()
        sum += sides[0]
    }
    return sum
}

fun readLines(): List<String> {
    val fileName = "src/AoC2015/Day2/input.txt"
    return try {
        Files.readAllLines(Paths.get(fileName))
    } catch (e: IOException) {
        e.printStackTrace()
        emptyList()
    }
}

fun main() {
    wrappingPaperCalculator()
}