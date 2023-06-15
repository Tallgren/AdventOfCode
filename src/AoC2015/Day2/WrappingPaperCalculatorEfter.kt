package AoC2015.Day2


import java.io.IOException
import java.nio.file.Files
import java.nio.file.Paths

//l*w*h
//2*l*w + 2*w*h + 2*h*l
//plus area of smallest side

fun wrappingPaperCalculator2() {
    val input = readLines()
    val result = calculatePaperRequired2(input)
    println(result)
    val result2 = calculateRibbonRequired2(input)
    println(result2)
}

fun calculateRibbonRequired2(input: List<String>): Int {
    return input.map { it.split("x").map(String::toInt)}.sumOf { Box(it[0],it[1],it[2]).ribbonSize() }
}

fun calculatePaperRequired2(input: List<String>): Int {
    //mappar input till int direkt och summerar med sumof istället för for(element in input)
    return input.map { it.split("x").map(String::toInt)}.sumOf { Box(it[0],it[1],it[2]).wrappingPaperSize() }
}

//skapar upp en data class av varje box och gör funktioner för att räkna ut saker av boxarna
data class Box(val w: Int, val l: Int, val h: Int) {
    fun wrappingPaperSize(): Int {
        val sides = listOf(l*w,w*h,h*l).sorted()
        return (2*l*w + 2*w*h + 2*h*l) + sides[0]
    }

    fun ribbonSize(): Int {
        val sides = listOf(w,l,h).sorted()
        //take 2 istället för drop sista
        return (sides.take(2).sum() * 2) + (l*w*h)
    }
}

fun readLines2(): List<String> {
    val fileName = "src/AoC2015/Day2/input.txt"
    return try {
        Files.readAllLines(Paths.get(fileName))
    } catch (e: IOException) {
        e.printStackTrace()
        emptyList()
    }
}

fun main() {
    wrappingPaperCalculator2()
}