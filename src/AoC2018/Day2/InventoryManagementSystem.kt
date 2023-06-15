package AoC2018.Day2

import java.io.IOException
import java.lang.StringBuilder
import java.nio.file.Files
import java.nio.file.Paths

fun inventoryManagementSystem() {
    //part 1
    val input = readLines()
    val result = calculateChecksum(input)
    println(result)

    //part 2
    val result2 = findStringsDifferingOneLetter(input)
    println(result2)
}

fun calculateChecksum(inputList: List<String>): Int {
    var sumDoubles = 0
    var sumTriples = 0

    for (element in inputList) {
        if (checkForTwoSimilar(element)) sumDoubles++
        if (checkForThreeSimilar(element)) sumTriples++
    }

    return sumDoubles*sumTriples
}

fun findStringsDifferingOneLetter(inputList: List<String>): String {
    var counter = 0

    while(true) {
        for (element in inputList) {
            //tar bort char på pos(counter) från element
            val compareString = StringBuilder(element).deleteCharAt(counter).toString()
            //filtrerar ut comparestring, mappar bort char på pos(counter)
            val tempInputList = inputList.filterNot{ e -> e == element }.map{s -> StringBuilder(s).deleteCharAt(counter).toString()}
            if (tempInputList.contains(compareString)) {
                return compareString
            }
        }
        counter++
    }
}

fun checkForTwoSimilar(element: String): Boolean {
    val array = element.toCharArray()
    for (letter in array) {
        if(array.count { it == letter } == 2) {
            return true
        }
    }
    return false
}

fun checkForThreeSimilar(element: String): Boolean {
    val array = element.toCharArray()
    for (letter in array) {
        if(array.count { it == letter } == 3) {
            return true
        }
    }
    return false
}

fun readLines(): List<String> {
    val fileName = "src/AoC2018/Day2/input.txt"
    return try {
        Files.readAllLines(Paths.get(fileName))
    } catch (e: IOException) {
        e.printStackTrace()
        emptyList()
    }
}

fun main() {
    inventoryManagementSystem()
}
